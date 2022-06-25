package com.example.tallerreparaciones_navarrofederico.ui

import RepairRepository
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.RepairAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayBuscarYrecyclerRepairsBinding
import com.example.tallerreparaciones_navarrofederico.entities.Repair

class DisplayBuscarYRecyclerRepairsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBuscarYrecyclerRepairsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBuscarYrecyclerRepairsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewRepairs()

    }

    private fun initRecyclerViewRepairs() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerListaDeReparaciones.layoutManager = LinearLayoutManager(this)
        binding.recyclerListaDeReparaciones.adapter =
            RepairAdapter(RepairRepository.get()) { repair -> onItemSelected(repair) }

        binding.recyclerListaDeReparaciones.addItemDecoration(decoration)
    }
    fun onItemSelected(repair: Repair){

    }
}