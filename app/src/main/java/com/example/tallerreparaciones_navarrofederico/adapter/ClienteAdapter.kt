package com.example.tallerreparaciones_navarrofederico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.R
import com.example.tallerreparaciones_navarrofederico.entities.Client

class ClienteAdapter( var clientList:List<Client>,val onClick: (Client)->Unit): RecyclerView.Adapter<ClienteViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
        return ClienteViewHolder(layoutInflater.inflate(R.layout.item_client,parent,false))
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
    val item = clientList[position]
        holder.render(item)
holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int =clientList.size



}