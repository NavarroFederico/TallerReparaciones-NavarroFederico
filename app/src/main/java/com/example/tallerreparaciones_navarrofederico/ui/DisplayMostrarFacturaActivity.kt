package com.example.tallerreparaciones_navarrofederico.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayMostrarFacturaBinding

class DisplayMostrarFacturaActivity : AppCompatActivity() {
    lateinit var binding: ActivityDisplayMostrarFacturaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDisplayMostrarFacturaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}