package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.models.Note

interface NoteRepository {

    fun saveNote(note: Note): Boolean
    fun getNoteById(id: Int): Note

}