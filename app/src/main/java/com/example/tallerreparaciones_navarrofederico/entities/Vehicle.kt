package com.example.tallerreparaciones_navarrofederico.entities

 open class Vehicle(
    val numberPlate: String,//patente
    val clientCode: Int,//codigo del cliente y dueño del vehiculo
    var insuranceCap: Double?,//tope de reintegro
    var insuranceCoverangeFrom: Double?//monto de reparacion a partir del cual aplica el seguro
) {
   open fun getDescuentoPorCobertura(total :Double):Double= 0.0
   open fun mostrarSiTieneSeguro():String="No se puede especificar si tiene o no seguro"
}
