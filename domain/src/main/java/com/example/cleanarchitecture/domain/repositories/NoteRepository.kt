package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.domain.models.Note

interface NoteRepository {

    fun saveNote(note: Note): Boolean
    fun getNote(): Note
}
