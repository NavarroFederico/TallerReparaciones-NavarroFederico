package com.example.tallerreparaciones_navarrofederico.adapter

import ClientRepository
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.databinding.ItemRepairBinding
import com.example.tallerreparaciones_navarrofederico.entities.Repair

class RepairsAdapter(
    private val repairsList: List<Repair>,
    val selectedRepairClickLister: (Repair) -> Unit) :
    RecyclerView.Adapter<RepairsAdapter.RepairsViewHolder>() {

    class RepairsViewHolder(val binding: ItemRepairBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairsViewHolder {
        val repairBinding = ItemRepairBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepairsViewHolder(repairBinding)
    }

    override fun onBindViewHolder(holder: RepairsViewHolder, position: Int) {
        val repair = repairsList[position]
        holder.binding.tvRepairCode.text = "Codigo de Reparación: #" +repair.code
        holder.binding.tvClientSurname.text =
            "Cliente: " + ClientRepository.get(repair.clientCode)?.surname + " " + ClientRepository.get(repair.clientCode)?.name

        holder.binding.tvClientCode.text = "Código de cliente: #" + repair.clientCode
        holder.binding.tvFecha.text = "Fecha de ingreso: " + repair.completionDate

        holder.itemView.setOnClickListener{
            selectedRepairClickLister(repair)
        }
    }

    override fun getItemCount(): Int {
        return repairsList.size
    }
}

