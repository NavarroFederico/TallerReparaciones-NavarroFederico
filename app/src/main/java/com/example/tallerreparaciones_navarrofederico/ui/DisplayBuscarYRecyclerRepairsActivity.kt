package com.example.tallerreparaciones_navarrofederico.ui

import RepairRepository
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.RepairsAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayBuscarYrecyclerRepairsBinding
import com.example.tallerreparaciones_navarrofederico.entities.Repair

val REPAIR_ID = "REPAIR_ID"

class DisplayBuscarYRecyclerRepairsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBuscarYrecyclerRepairsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBuscarYrecyclerRepairsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerViewRepairs()

    }

    private fun setUpRecyclerViewRepairs() {
        val selectRepairClickLister = { repair: Repair ->
            Toast.makeText(this, "Mostrar factura ${repair.code} ", Toast.LENGTH_SHORT).show()

            val codigoRepair = repair.code
            val intent = Intent(this, DisplayMostrarFacturaActivity::class.java)
            intent.putExtra(
                REPAIR_ID, codigoRepair
            )
            startActivity(intent)

        }

        binding.recyclerListaDeReparaciones.adapter =
            RepairsAdapter(RepairRepository.get(), selectRepairClickLister)
        binding.recyclerListaDeReparaciones.layoutManager = LinearLayoutManager(this)

    }
}