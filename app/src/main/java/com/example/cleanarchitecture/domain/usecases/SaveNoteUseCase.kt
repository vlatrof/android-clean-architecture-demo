package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repository.NoteRepository

class SaveNoteUseCase(private val noteRepository: NoteRepository) {

    fun execute(note: Note): Boolean {
        return noteRepository.saveNote(note)
    }

}