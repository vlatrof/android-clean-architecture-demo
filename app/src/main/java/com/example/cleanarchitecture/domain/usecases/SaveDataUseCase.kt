package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.App
import com.example.cleanarchitecture.domain.models.Data

class SaveDataUseCase {

    fun execute(data: Data): Boolean {
        App.storedData = data
        return true
    }

}