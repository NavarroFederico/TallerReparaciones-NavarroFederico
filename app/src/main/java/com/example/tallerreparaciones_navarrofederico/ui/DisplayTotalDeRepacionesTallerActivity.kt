package com.example.tallerreparaciones_navarrofederico.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tallerreparaciones_navarrofederico.databinding.ActivityDisplayTotalDeRepacionesTallerBinding

class DisplayTotalDeRepacionesTallerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayTotalDeRepacionesTallerBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityDisplayTotalDeRepacionesTallerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
    }
}