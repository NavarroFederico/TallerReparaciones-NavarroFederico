package com.example.tallerreparaciones_navarrofederico.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.RepairsAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayRepairsFilterByClientBinding
import com.example.tallerreparaciones_navarrofederico.entities.Repair

class DisplayRepairsFilterByClientActivity : AppCompatActivity() {

    lateinit var binding: ActivityDisplayRepairsFilterByClientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayRepairsFilterByClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val codeClientSelect = intent.getIntExtra(CLIENT_ID, 0)

        setUpReciclerView(codeClientSelect)
    }

    private fun setUpReciclerView(codeClientSelect: Int) {
        val selectRepairClickLister = { repair: Repair ->
            Toast.makeText(this, "Mostrar factura ${repair.code} ", Toast.LENGTH_SHORT).show()

            val codigoRepair = repair.code
            val intent = Intent(this, DisplayMostrarFacturaActivity::class.java)
            intent.putExtra(
                REPAIR_ID, codigoRepair
            )
            startActivity(intent)
        }

        binding.recyclerViewRepairsByClient.adapter =
            RepairsAdapter(
                RepairRepository.getAllRepairByClientCode(codeClientSelect),
                selectRepairClickLister
            )
        binding.recyclerViewRepairsByClient.layoutManager = LinearLayoutManager(this)
    }
}