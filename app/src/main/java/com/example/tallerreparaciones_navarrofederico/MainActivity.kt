package com.example.tallerreparaciones_navarrofederico

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityMainBinding
import com.example.tallerreparaciones_navarrofederico.ui.DisplayBotonOpcionesActivity
import com.example.tallerreparaciones_navarrofederico.ui.DisplayBuscarYRecyclerClientesActivity
import com.example.tallerreparaciones_navarrofederico.ui.DisplayMostrarTotalDeUnClienteActivity
import com.example.tallerreparaciones_navarrofederico.ui.DisplayRecyclerClientsActivity

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
    }
}

