package com.example.cleanarchitecture.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.d("main_vm", "MainVM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("main_vm", "MainVM destroyed because of destroying MainActivity")
    }

}