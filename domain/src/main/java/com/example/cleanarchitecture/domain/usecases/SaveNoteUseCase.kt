package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repositories.NoteRepository

class SaveNoteUseCase(private val noteRepository: NoteRepository) {

    fun execute(note: Note): Boolean {

        if(noteRepository.getNote() == note) {
            return true
        }

        return noteRepository.saveNote(note)
    }

}