package com.example.tallerreparaciones_navarrofederico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.R
import com.example.tallerreparaciones_navarrofederico.entities.Repair

class RepairAdapter(private val repairList:List<Repair>,val onClickListener:(Repair)->Unit):RecyclerView.Adapter<RepairViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RepairViewHolder(layoutInflater.inflate(R.layout.item_repair,parent,false))
    }

    override fun onBindViewHolder(holder: RepairViewHolder, position: Int) {
        val item = repairList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = repairList.size

}