package com.example.tallerreparaciones_navarrofederico.entities

import RepairRepository
import SparePartRepository
import java.time.LocalDate

class Repair(
    val code: Int,//codifo de la reparacion que la identifica
    val clientCode: Int,//codigo del cliente y dueño del vehiculo
    val completionDate: LocalDate,//fecha en la que se efectup la reparacion
    val sparePartsUsed: Map<Int, Int>,// respuestos; codigo ,cantidad
    val hoursWorked: Int,//horas trabajadas
    val precio_por_hora: Double = 500.0

) {
    fun validarStock(codeDeParte: Int): Boolean {
        var hayStock = false
        val stockActual = SparePartRepository.get(codeDeParte)?.unitsInStock

        if (stockActual!! >= sparePartsUsed.getValue(codeDeParte)) {
            hayStock = true
        }
        return hayStock
    }

    fun validarSiEsLaPrimeraReparacionDelMes(): Boolean {
        val month = this.completionDate.month
        val year = this.completionDate.year

        val repairFilter = RepairRepository.searchRepairByMonth_Year_ClientCode(month, year, this.clientCode)
        var esLaPrimera = false

        if (repairFilter.size == 1) {
            esLaPrimera = true
        } else {
            for (aux in repairFilter) {
                esLaPrimera = aux.completionDate.isAfter(this.completionDate)
            }
        }
        return esLaPrimera
    }


    fun mostrarFacturaDeReparacion() {
//Todo falta completar
        val serviceClient = ClientService()

        val cliente = serviceClient.categorizarCliente(clientCode)
        val serviceVehicle = VehicleService()
        val vehiculo = serviceVehicle.categorizarUnVehiculoConCoberturaOSinCobertura(clientCode)

        val totalSinDescuentos = calcularTotalSinDescuentos()
        val descuentoPorTipoDeCliente = cliente?.getDescuentoAAplicar(totalSinDescuentos)
        var descuentoPorSeguro = 0.0


        if (validarSiEsLaPrimeraReparacionDelMes()) {
            descuentoPorSeguro = vehiculo?.getDescuentoPorCobertura(calcularTotalSinDescuentos())!!
        }
        val montoTotalConDescuentosAplicados =
            totalSinDescuentos - (descuentoPorTipoDeCliente?.plus(descuentoPorSeguro)!!)

        if (vehiculo == null) {
            println("No se ha podido imprimir la factura. Revise los datos del vehiculo")
        } else {
            println("""
                
                
                
                    ------------------------------------------------------------------------------------------------------- 
                                                           + FACTURA*
                    
                         Fecha de hoy ${LocalDate.now()} , fecha de reparacion : $completionDate
                         Reparación # $code
                      
                         La siguiente factura corresponde al cliente # ${cliente.code}. ${cliente.name}${cliente.surname}
                         El vehículo ingresado tiene la patente ${vehiculo.numberPlate}.
                         ¿Tiene seguro? ${vehiculo.mostrarSiTieneSeguro()}
                        
                         ${obtenerDetallesDeRepuestosUtilizados()}
                         
                          Subtotal de Repuestos: ${calcularMontoTotalPorRepuestoUsados()}
                        
                         La mano de Obra:
                         Horas trabajadas : $hoursWorked
                         Precio por Hora : $precio_por_hora
                         Subtotal: ${calcularSubtotalPorManoDeObra()}
                        
                         Monto total sin descuento: ${calcularTotalSinDescuentos()}
                         
                         Los descuentos aplicados en la reparacion fueron:
                            Por cliente: $descuentoPorTipoDeCliente
                            Por seguro:$descuentoPorSeguro
                        
                                                                            Monto total:
                                                                                        $montoTotalConDescuentosAplicados
                            
                    -------------------------------------------------------------------------------------------------------
             
                """.trimIndent()
            )
            println("")

        }
    }


fun obtenerDetallesDeRepuestosUtilizados(): String {
    var texto = ""
    for (parteUsada in sparePartsUsed) {
        val code = parteUsada.key
        val unitsUsed = parteUsada.value
        val priceByUnit = SparePartRepository.get(code)?.price

        if (validarStock(code)) {
            val subTotalPorParte = priceByUnit?.times(unitsUsed)
            texto += """
                        # $code : ${SparePartRepository.get(code)?.name}
                        Precio por Unidad $priceByUnit
                        Unidades utilizadas: $unitsUsed
                        Subtotal: $subTotalPorParte
                        
                """

        } else {
            texto +=
                """ 
                        # $code : ${SparePartRepository.get(code)?.name}
                        NO POSEE STOCK DISPONIBLE PARA ESTA REPARACIÖN
                """
        }
    }
    return texto
}

fun calcularMontoTotalPorRepuestoUsados(): Double {
    var montoTotal = 0.0
    for (sparePartActual in sparePartsUsed) {
        val codeDeParte = sparePartActual.key
        val precioPorUnidad = SparePartRepository.get(codeDeParte)?.price
        val cantidadUsadas = sparePartActual.value

        if (precioPorUnidad != null && validarStock(codeDeParte)) {
            montoTotal += precioPorUnidad * cantidadUsadas

        }
    }
    return montoTotal
}

fun calcularSubtotalPorManoDeObra(): Double {
    return this.hoursWorked.times(precio_por_hora)
}

fun calcularTotalSinDescuentos(): Double =
    calcularMontoTotalPorRepuestoUsados().plus(calcularSubtotalPorManoDeObra())


override fun toString(): String {
    return "Repair(code=$code, clientCode=$clientCode, completionDate=$completionDate, sparePartsUsed=$sparePartsUsed, hoursWorked=$hoursWorked)"
}

}



