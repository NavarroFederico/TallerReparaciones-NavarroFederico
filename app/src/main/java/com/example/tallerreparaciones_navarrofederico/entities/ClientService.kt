package com.example.tallerreparaciones_navarrofederico.entities

class ClientService {

    fun categorizarCliente(codigoDeCliente: Int): Client? {

        val clienteAux = ClientRepository.get(codigoDeCliente)
        if (clienteAux != null) {
            return if (clienteAux.cantidadDeReparaciones() == 1) {
                NewClient(codigoDeCliente, clienteAux.name, clienteAux.surname)
            } else {
                RegularClient(codigoDeCliente, clienteAux.name, clienteAux.surname)
            }
        }
        return null
        /*
          if (clienteAux.cantidadDeReparaciones() == 1) {
                return NewClient(codigoDeCliente, clienteAux.name, clienteAux.surname)
            } else {
                return RegularClient(codigoDeCliente, clienteAux.name, clienteAux.surname)
            }
         */
        /*
         fun calcularMontoTotalConDescuentosAplicados(clientActual: Client, vehicleActual: Vehicle): Double {
        val totalSinDescuentos = calcularTotalSinDescuentos()
        val descuentoPorTipoDeCliente = clientActual.getDescuentoAAplicar(totalSinDescuentos)
        var descuentoPorSeguro = 0.0
        if (validarSiEsLaPrimeraReparacionDelMes()) {
            descuentoPorSeguro = vehicleActual.getDescuentoPorCobertura(calcularTotalSinDescuentos())
        }
        return totalSinDescuentos - (descuentoPorTipoDeCliente.plus(descuentoPorSeguro))
    }
         */
    }
}
