package com.example.tallerreparaciones_navarrofederico.entities

class NewClient(code: Int, name: String, surname: String) : Client(code, name, surname) {
    override fun getDescuentoAAplicar(total: Double) = total * 0.40

}