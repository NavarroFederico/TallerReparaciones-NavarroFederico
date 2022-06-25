package com.example.tallerreparaciones_navarrofederico.ui

import ClientRepository
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tallerreparaciones_navarrofederico.adapter.ClienteAdapter
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayBuscarYrecyclerClientesBinding
import com.example.tallerreparaciones_navarrofederico.entities.Client

class DisplayBuscarYRecyclerClientesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBuscarYrecyclerClientesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBuscarYrecyclerClientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewClients()


    }

    val adapter = ClienteAdapter(ClientRepository.get()) { client -> onClickClient(client) }
    private fun onClickClient(client: Client) {

    }

    private fun initRecyclerViewClients() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerListaDeClientes.layoutManager = manager
        binding.recyclerListaDeClientes.adapter = adapter
        ///click listener

        val clienteFiltrado = ClientRepository.get().filter { c -> c.code == 2 }.toList()
        adapter.clientList = clienteFiltrado
        adapter.notifyDataSetChanged()

        //listener borrar
        adapter.clientList = ClientRepository.get()
        adapter.notifyDataSetChanged()

        binding.recyclerListaDeClientes.addItemDecoration(decoration)
    }
}