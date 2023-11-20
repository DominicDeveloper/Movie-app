package com.asadbek.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asadbek.movieapp.databinding.ActivityAboutActivtiyBinding

class AboutActivtiy : AppCompatActivity() {
    lateinit var binding: ActivityAboutActivtiyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}