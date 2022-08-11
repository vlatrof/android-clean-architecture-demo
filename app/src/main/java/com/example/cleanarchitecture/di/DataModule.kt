package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repositories.NoteRepositoryImpl
import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.sharedprefs.SharedPrefNoteStorage
import com.example.cleanarchitecture.domain.repositories.NoteRepository
import org.koin.dsl.module

val dataModule = module {

    single<NoteStorage> {
        SharedPrefNoteStorage(context = get())
    }

    single<NoteRepository> {
        NoteRepositoryImpl(noteStorage = get())
    }

}