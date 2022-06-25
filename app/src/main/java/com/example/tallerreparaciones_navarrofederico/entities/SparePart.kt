package com.example.tallerreparaciones_navarrofederico.entities
//repuesto
 data class SparePart(val code: Int,
                val name: String,//nombre del repuesto
                val price: Double,//costo por unidad
                var unitsInStock: Int)//stock {


