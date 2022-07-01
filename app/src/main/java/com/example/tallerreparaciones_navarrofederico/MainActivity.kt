package com.example.tallerreparaciones_navarrofederico

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityMainBinding
import com.example.tallerreparaciones_navarrofederico.ui.*

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
            val intent = Intent(this, DisplayRecyclerClientsActivity::class.java)
            startActivity(intent)
        }
        //boton gananciaTotal
        mainBinding.bCalcularGananciaDelTaller.setOnClickListener {
            val intent = Intent(this, DisplayTotalDeRepacionesTallerActivity::class.java)
            startActivity(intent)
        }

        //salir
        mainBinding.bSalir.setOnClickListener {
            finish()
            android.os.Process.killProcess(android.os.Process.myPid())


        }
    }
}

