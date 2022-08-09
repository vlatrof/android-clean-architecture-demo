package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repositories.NoteRepository

class GetNoteUseCase(private val noteRepository: NoteRepository) {

    fun execute(): Note {

        return noteRepository.getNote()
    }

}