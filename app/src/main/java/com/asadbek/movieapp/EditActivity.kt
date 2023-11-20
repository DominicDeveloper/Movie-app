package com.asadbek.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asadbek.movieapp.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}