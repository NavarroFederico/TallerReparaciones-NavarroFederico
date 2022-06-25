package com.example.tallerreparaciones_navarrofederico

import ClientRepository
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.adapter.ClienteAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityMainBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client
import com.example.tallerreparaciones_navarrofederico.ui.DisplayBotonOpcionesActivity
import com.example.tallerreparaciones_navarrofederico.ui.DisplayBuscarYRecyclerClientesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        //boton mostrar factura a DisplayOpciones
        mainBinding.bMostrarFactura.setOnClickListener {
            val intent = Intent(this, DisplayBotonOpcionesActivity::class.java)
            startActivity(intent)
        }
        //boton mostrarTotalDeunCliente
        mainBinding.bCalcularTotalDeReparaciones.setOnClickListener {
            val intent = Intent(this, DisplayBuscarYRecyclerClientesActivity::class.java)
            startActivity(intent)
        }
    }
}

