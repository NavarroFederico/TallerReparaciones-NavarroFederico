package com.example.tallerreparaciones_navarrofederico.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayTotalDeRepacionesTallerBinding

class DisplayTotalDeRepacionesTallerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayTotalDeRepacionesTallerBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDisplayTotalDeRepacionesTallerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}