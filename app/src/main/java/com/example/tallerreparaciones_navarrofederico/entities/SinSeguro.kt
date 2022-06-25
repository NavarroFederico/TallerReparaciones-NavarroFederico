package com.example.tallerreparaciones_navarrofederico.entities

class SinSeguro(numberPlate: String, clientCode: Int, insuranceCap: Double?, insuranceCoverangeFrom: Double?): Vehicle(numberPlate, clientCode,
    insuranceCap,
    insuranceCoverangeFrom
) {
    override fun getDescuentoPorCobertura(total: Double): Double {
        return super.getDescuentoPorCobertura(total)
    }

    override fun mostrarSiTieneSeguro(): String ="No tiene seguro"

}
