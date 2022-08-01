package com.example.cleanarchitecture.domain

import android.app.Application
import com.example.cleanarchitecture.domain.models.Data

class App : Application() {

    companion object {

        var storedData = Data()

    }

}