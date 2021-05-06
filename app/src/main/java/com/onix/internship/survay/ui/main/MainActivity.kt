package com.onix.internship.survay.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onix.internship.survay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}