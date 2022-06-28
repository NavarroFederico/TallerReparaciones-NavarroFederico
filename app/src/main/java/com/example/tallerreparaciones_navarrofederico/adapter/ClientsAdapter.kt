package com.example.tallerreparaciones_navarrofederico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.databinding.ItemClientBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client

class ClientsAdapter(var clientList: List<Client>, val selectClientClickLister: (Client) -> Unit) :
    RecyclerView.Adapter<ClientsAdapter.ClientsViewHolder>() {

    class ClientsViewHolder(val binding: ItemClientBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsViewHolder {
        val clientBinding =
            ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ClientsViewHolder(clientBinding)
    }

    override fun onBindViewHolder(holder: ClientsViewHolder, position: Int) {
        val client = clientList[position]

        holder.binding.tvClientCode.text = "Código de Cliente: #" + client.code.toString()
        holder.binding.tvClientSurname.text = "Apellido: " + client.surname.toString()
        holder.binding.tvClientName.text = "Nombre: " + client.name.toString()
        holder.binding.tvCantidadDeReparaciones.text =
            "Cantidad de Reparaciones: " + client.cantidadDeReparaciones().toString()
        holder.itemView.setOnClickListener {
            selectClientClickLister(client)
        }
    }

    override fun getItemCount(): Int = clientList.size

}