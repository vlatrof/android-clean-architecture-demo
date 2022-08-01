package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.App
import com.example.cleanarchitecture.domain.models.Data

class GetDataUseCase {

    fun execute(): Data {
        return App.storedData
    }

}