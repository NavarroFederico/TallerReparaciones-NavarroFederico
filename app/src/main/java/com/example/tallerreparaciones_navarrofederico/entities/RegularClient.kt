package com.example.tallerreparaciones_navarrofederico.entities

class RegularClient(code: Int, name: String, surname: String) : Client(code, name, surname) {
    override fun getDescuentoAAplicar(total: Double): Double {
        var descuento = 0.0
        if (total >= 15000) {
           descuento= total * 0.15
        }
        return descuento
    }

}