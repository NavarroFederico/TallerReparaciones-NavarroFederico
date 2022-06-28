package com.example.tallerreparaciones_navarrofederico.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.ClientsAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayRecyclerClientsBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client

class DisplayRecyclerClientsActivity : AppCompatActivity() {
   private lateinit var binding: ActivityDisplayRecyclerClientsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=  ActivityDisplayRecyclerClientsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView() {

        val selectClientClickLister = { client: Client ->
            Toast.makeText(
                this,
                "Seleccionaste cliente : ${client.name} ${client.surname}",
                Toast.LENGTH_LONG
            ).show()
            val clientCodeSelect = client.code
            val intent = Intent(this, DisplayMostrarTotalDeUnClienteActivity::class.java)
            intent.putExtra("CODE_ID", clientCodeSelect)
            startActivity(intent)

        }
        var adapter = ClientsAdapter(ClientRepository.get(), selectClientClickLister)
        binding.recyclerListaDeClientes.layoutManager = LinearLayoutManager(this)
        binding.recyclerListaDeClientes.adapter = adapter


    }
}