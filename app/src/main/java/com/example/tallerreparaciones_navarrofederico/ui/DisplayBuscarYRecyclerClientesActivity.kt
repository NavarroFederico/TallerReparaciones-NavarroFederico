package com.example.tallerreparaciones_navarrofederico.ui

import ClientRepository
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.ClientsAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayBuscarYrecyclerClientesBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client

const val CLIENT_ID = "CLIENT_EDAD"

class DisplayBuscarYRecyclerClientesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBuscarYrecyclerClientesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBuscarYrecyclerClientesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView() {

        val selectClientClickLister = { client: Client ->
            Toast.makeText(
                this,
                "Seleccionaste cliente : ${client.name} ${client.surname}",
                Toast.LENGTH_SHORT
            ).show()
            val clientCodeSelect = client.code
            val intent = Intent(this, DisplayRepairsFilterByClientActivity::class.java)
            intent.putExtra(CLIENT_ID, clientCodeSelect)
            startActivity(intent)
        }
        val adapter = ClientsAdapter(ClientRepository.get(), selectClientClickLister)
        binding.recyclerListaDeClientes.layoutManager = LinearLayoutManager(this)
        binding.recyclerListaDeClientes.adapter = adapter
    }
}