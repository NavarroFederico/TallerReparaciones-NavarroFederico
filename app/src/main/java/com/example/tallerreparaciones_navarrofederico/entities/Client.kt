package com.example.tallerreparaciones_navarrofederico.entities

import RepairRepository

open class Client(
    val code: Int,
    val name: String,
    val surname: String
) {
    open fun getDescuentoAAplicar(total: Double): Double = total

    fun cantidadDeReparaciones(): Int {
        return RepairRepository.getAllRepairByClientCode(code).size
    }

    fun calcularMontoTotalDeUnClienteEnTodasSusReparaciones(): Double {
        println("\tReparaciones del cliente: $code $name $surname")
        var montoTotal = 0.0
        val allRepairs = RepairRepository.getAllRepairByClientCode(code)
        for (actual in allRepairs) {

            val montoTotalSinDescuento = actual.calcularTotalSinDescuentos()
            val descuentoPorTipoDeCliente = getDescuentoAAplicar(montoTotalSinDescuento)
            val serviceVehicle = VehicleService()
            val vehiculo = serviceVehicle.categorizarUnVehiculoConCoberturaOSinCobertura(code)
            var descuentoPorSeguro = 0.0
            if (actual.validarSiEsLaPrimeraReparacionDelMes()) {
                descuentoPorSeguro = vehiculo?.getDescuentoPorCobertura(montoTotalSinDescuento)!!
            }
            val montoReparacionActual = montoTotalSinDescuento - (descuentoPorTipoDeCliente.plus(descuentoPorSeguro!!))
            println("""
                Reparacion #${actual.code}-->$${montoReparacionActual}""".trimIndent())

            montoTotal += montoReparacionActual
        }
        return montoTotal
    }
}

