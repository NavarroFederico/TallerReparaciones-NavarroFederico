package com.example.tallerreparaciones_navarrofederico.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.R
import com.example.tallerreparaciones_navarrofederico.databinding.ItemClientBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client

class ClienteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemClientBinding.bind(view)


    fun render(clientModel: Client) {
        binding.tvClientCode.text = "Código de Cliente: #" + clientModel.code.toString()
        binding.tvClientSurname.text = "Apellido: " + clientModel.surname.toString()
        binding.tvClientName.text = "Nombre: " + clientModel.name.toString()
        binding.tvCantidadDeReparaciones.text =
            "Cantidad de Reparaciones: " + clientModel.cantidadDeReparaciones().toString()

        //para gestionar el click en el item
        itemView.setOnClickListener {
            Toast.makeText(
                binding.tvClientName.context, "Mostrar factura", Toast.LENGTH_SHORT
            ).show()
        }
    }
}