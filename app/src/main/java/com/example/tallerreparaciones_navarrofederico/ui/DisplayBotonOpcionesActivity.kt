package com.example.tallerreparaciones_navarrofederico.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tallerreparaciones_navarrofederico.R
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayBotonOpcionesBinding

class DisplayBotonOpcionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBotonOpcionesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDisplayBotonOpcionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bBusquedaPorReparacion.setOnClickListener {
            val intent = Intent(this,DisplayBuscarYRecyclerRepairsActivity::class.java)
            startActivity(intent)
        }
        binding.bBusquedaPorCliente.setOnClickListener {
            val intent = Intent(this,DisplayBuscarYRecyclerClientesActivity::class.java)
            startActivity(intent)
        }
    }

}