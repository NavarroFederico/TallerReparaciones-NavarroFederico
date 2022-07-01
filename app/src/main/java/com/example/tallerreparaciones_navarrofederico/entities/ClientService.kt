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

    }
}
