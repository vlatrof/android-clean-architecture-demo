package com.example.cleanarchitecture.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.d("ls", "MainVM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ls", "MainVM destroyed because MainActivity destroyed")
    }

}