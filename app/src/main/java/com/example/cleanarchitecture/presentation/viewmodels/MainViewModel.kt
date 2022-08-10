package com.example.cleanarchitecture.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.d("lf", "MainVM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("lf", "MainVM destroyed because of destroying MainActivity")
    }

}