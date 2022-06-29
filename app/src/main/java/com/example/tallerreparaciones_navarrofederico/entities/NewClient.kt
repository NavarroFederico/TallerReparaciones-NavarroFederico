package com.example.tallerreparaciones_navarrofederico.entities

class NewClient(code: Int, name: String, surname: String) : Client(code, name, surname) {
    override fun getDescuentoAAplicar(total: Double) = total * 0.40

/*
    fun calcularMontoTotalDeUnClienteEnTodasSusReparaciones() {
        var montoTotal = 0.0
        val serviceClient = ClientService()
        val serviceVehicle = VehicleService()
        val vehiculo = serviceVehicle.categorizarUnVehiculoConCoberturaOSinCobertura(clientCode)
        val totalSinDescuentos = calcularTotalSinDescuentos()
        val descuentoPorTipoDeCliente = cliente?.aplicarDescuento(totalSinDescuentos)
        val descuentoPorSeguro = vehiculo?.aplicarDescuentoPorCobertura(calcularTotalSinDescuentos())
        val montoTotalConDescuentosAplicados =
            totalSinDescuentos - (descuentoPorTipoDeCliente?.plus(descuentoPorSeguro!!)!!)
        val listaDeReparacionesDeEsteCliente =
            RepairRepository.get().filter { it.clientCode == code }
        for (actual in listaDeReparacionesDeEsteCliente) {
            val aux = (actual.calcularMontoTotalPorRepuestoUsados().plus(actual.calcularSubtotalPorManoDeObra()))
        }
//dentro del for tengo que sumar total por respuestos + totalpor mano de obra
        //aplicar descuento por cliente
        //si cliente tiene mas de una reparacion en el mes Solo se aplica 1 vez al mes,
    // y en la primera reparación del mes realizada al vehículo.
    }
*/
}