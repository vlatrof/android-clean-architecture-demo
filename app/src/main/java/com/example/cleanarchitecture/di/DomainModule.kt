package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repositories.NoteRepository
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideSaveNoteUseCase(noteRepository: NoteRepository): SaveNoteUseCase {
        return SaveNoteUseCase(noteRepository = noteRepository)
    }

    @Provides
    fun provideGetNoteUseCase(noteRepository: NoteRepository): GetNoteUseCase {
        return GetNoteUseCase(noteRepository = noteRepository)
    }

}