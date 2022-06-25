package com.example.tallerreparaciones_navarrofederico.entities

import VehicleRepository

class VehicleService {
    fun categorizarUnVehiculoConCoberturaOSinCobertura(codigoDeCliente: Int): Vehicle? {
        val vehicleAux = VehicleRepository.getByClientCode(codigoDeCliente)
        if (vehicleAux != null) {
            return if (vehicleAux.insuranceCap != null && vehicleAux.insuranceCoverangeFrom != null) {
                ConSeguro(
                    vehicleAux.numberPlate,
                    vehicleAux.clientCode,
                    vehicleAux.insuranceCap,
                    vehicleAux.insuranceCoverangeFrom
                )
            } else {
                SinSeguro(
                    vehicleAux.numberPlate,
                    vehicleAux.clientCode,
                    vehicleAux.insuranceCap,
                    vehicleAux.insuranceCoverangeFrom
                )
            }
        }
        return null

    }
}
