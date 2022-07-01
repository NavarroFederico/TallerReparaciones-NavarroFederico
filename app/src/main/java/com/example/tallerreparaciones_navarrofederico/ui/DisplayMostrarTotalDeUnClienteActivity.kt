package com.example.tallerreparaciones_navarrofederico.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayMostrarTotalDeUnClienteBinding
import com.example.tallerreparaciones_navarrofederico.entities.ClientService

class DisplayMostrarTotalDeUnClienteActivity : AppCompatActivity() {
    lateinit var binding: ActivityDisplayMostrarTotalDeUnClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayMostrarTotalDeUnClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val codeClientSelect = intent.getIntExtra("CODE_ID", 0)
        mostrarDatosYTotalDeReparacionDeUnCliente(codeClientSelect)

    }

    fun mostrarDatosYTotalDeReparacionDeUnCliente(codeClient: Int) {
        val clientService = ClientService()
        val client = clientService.categorizarCliente(codeClient)
        val montoTotal = client?.calcularMontoTotalDeUnClienteEnTodasSusReparaciones()

        binding.tvClientCode.text = "Código de Cliente: #" + client?.code
        binding.tvClientSurname.text = "Apellido: " + client?.surname.toString()
        binding.tvClientName.text = "Nombre: " + client?.name.toString()
        binding.tvTotalDeReparaciones.text = "Total por reparaciones"
        binding.tvCantidadDeReparaciones.text =
            "Cantidad de Reparaciones: " + client?.cantidadDeReparaciones().toString()
        binding.tvTotal.text = "$$montoTotal"
    }
}
