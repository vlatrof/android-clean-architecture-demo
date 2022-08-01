package com.example.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetData.setOnClickListener { btnGetDataOnClick() }
        binding.btnSaveData.setOnClickListener { btnSaveDataOnClick() }

    }

    private fun btnGetDataOnClick() {
        TODO("Not yet implemented")
    }

    private fun btnSaveDataOnClick() {
        TODO("Not yet implemented")
    }

}