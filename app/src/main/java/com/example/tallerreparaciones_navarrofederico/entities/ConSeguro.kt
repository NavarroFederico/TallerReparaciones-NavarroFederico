package com.example.tallerreparaciones_navarrofederico.entities

class ConSeguro(numberPlate: String, clientCode: Int, insuranceCap: Double?, insuranceCoverangeFrom: Double?) : Vehicle(numberPlate, clientCode,
    insuranceCap,
    insuranceCoverangeFrom){

    override fun getDescuentoPorCobertura(total: Double): Double {
    val descuentoPorCobertura: Double

    if (total >= insuranceCoverangeFrom!!&& total <= insuranceCap!!){
                    descuentoPorCobertura=total

                }else if (total >= insuranceCap!!) {
                    descuentoPorCobertura=insuranceCap!!
                }else {
                    descuentoPorCobertura=0.0
                }
        return descuentoPorCobertura
    }

    override fun mostrarSiTieneSeguro(): String ="Si tiene seguro"

}