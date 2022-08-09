package com.example.cleanarchitecture.data.storages

import com.example.cleanarchitecture.data.storages.models.Note

interface NoteStorage {

    fun saveNote(note: Note): Boolean
    fun getNote(): Note

}