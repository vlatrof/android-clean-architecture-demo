package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.data.repositories.NoteRepositoryImpl
import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.sharedprefs.SharedPrefNoteStorage
import com.example.cleanarchitecture.domain.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNoteStorage(@ApplicationContext context: Context) : NoteStorage {
        return SharedPrefNoteStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteStorage: NoteStorage) : NoteRepository {
        return NoteRepositoryImpl(noteStorage = noteStorage)
    }

}