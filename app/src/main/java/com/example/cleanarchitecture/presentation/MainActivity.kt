package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.App
import com.example.cleanarchitecture.domain.models.Data
import com.example.cleanarchitecture.domain.usecases.GetDataUseCase
import com.example.cleanarchitecture.domain.usecases.SaveDataUseCase

class MainActivity : AppCompatActivity() {

    private val getDataUseCase = GetDataUseCase()
    private val saveDataUseCase = SaveDataUseCase()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetData.setOnClickListener { btnGetDataOnClick() }
        binding.btnSaveData.setOnClickListener { btnSaveDataOnClick() }

    }

    private fun btnGetDataOnClick() {
        val data = getDataUseCase.execute()
        renderData(data)
    }

    private fun btnSaveDataOnClick() {
        val data = Data(binding.etInputData.text.toString())
        saveDataUseCase.execute(data)
    }

    private fun renderData(data: Data) {

        if (data.value == "") {
            binding.tvData.text = getString(R.string.tv_data_placeholder_text)
            return
        }

        binding.tvData.text = data.value
    }

}