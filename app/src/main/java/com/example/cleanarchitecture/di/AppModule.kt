package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(saveNoteUseCase = get(), getNoteUseCase = get())
    }

}