package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repository.NoteRepository

class NoteRepositoryImpl : NoteRepository {

    override fun saveNote(note: Note): Boolean {

        // todo
        return true
    }

    override fun getNoteById(id: Int): Note {

        // todo
        return Note(text = "Dummy note")
    }

}