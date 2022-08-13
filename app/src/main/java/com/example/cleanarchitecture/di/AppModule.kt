package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import com.example.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module

@Module
class AppModule(private val context: Context) {

    fun provideContext(): Context {
        return context
    }

    fun provideMainViewModelFactory(

        saveNoteUseCase: SaveNoteUseCase,
        getNoteUseCase: GetNoteUseCase

    ): MainViewModelFactory {

        return MainViewModelFactory(
            saveNoteUseCase = saveNoteUseCase,
            getNoteUseCase = getNoteUseCase)

    }


}