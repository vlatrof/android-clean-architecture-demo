package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repositories.NoteRepository
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import dagger.Module

@Module
class DomainModule {

    fun provideSaveNoteUseCase(noteRepository: NoteRepository): SaveNoteUseCase {
        return SaveNoteUseCase(noteRepository = noteRepository)
    }

}