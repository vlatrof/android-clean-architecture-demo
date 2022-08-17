package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import com.example.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(

        saveNoteUseCase: SaveNoteUseCase,
        getNoteUseCase: GetNoteUseCase

    ): MainViewModelFactory {

        return MainViewModelFactory(
            saveNoteUseCase = saveNoteUseCase,
            getNoteUseCase = getNoteUseCase)

    }

}