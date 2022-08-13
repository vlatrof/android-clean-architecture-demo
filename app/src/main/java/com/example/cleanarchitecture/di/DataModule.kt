package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.data.repositories.NoteRepositoryImpl
import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.sharedprefs.SharedPrefNoteStorage
import com.example.cleanarchitecture.domain.repositories.NoteRepository
import dagger.Module

@Module
class DataModule {

    fun provideNoteStorage(context: Context): NoteStorage {
        return SharedPrefNoteStorage(context = context)
    }

    fun provideNoteRepository(noteStorage: NoteStorage): NoteRepository {
        return NoteRepositoryImpl(noteStorage = noteStorage)
    }

}