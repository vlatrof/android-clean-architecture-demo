package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetNoteUseCase> {
        GetNoteUseCase(noteRepository = get())
    }

    factory<SaveNoteUseCase> {
        SaveNoteUseCase(noteRepository = get())
    }



}