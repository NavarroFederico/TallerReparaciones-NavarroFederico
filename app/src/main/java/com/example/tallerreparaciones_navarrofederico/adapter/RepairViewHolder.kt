package com.example.tallerreparaciones_navarrofederico.adapter

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerreparaciones_navarrofederico.databinding.ItemRepairBinding
import com.example.tallerreparaciones_navarrofederico.entities.Repair
import com.example.tallerreparaciones_navarrofederico.ui.DisplayMostrarFacturaActivity

class RepairViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRepairBinding.bind(view)

    fun render(repairModel: Repair, onClickListener:(Repair)->Unit) {
        binding.tvRepairCode.text = "Codigo de Reparación: #" + repairModel.code.toString()
        binding.tvClientSurname.text =
            "Cliente: " + ClientRepository.get(repairModel.clientCode)?.surname.toString() + " " + ClientRepository.get(
                repairModel.clientCode
            )?.name.toString()
        binding.tvClientCode.text = "Código de cliente: #" + repairModel.clientCode
        binding.tvFecha.text = "Fecha de ingreso: " + repairModel.completionDate

        //para gestionar el click en el item
        itemView.setOnClickListener {
            onClickListener(repairModel)}

    }
}