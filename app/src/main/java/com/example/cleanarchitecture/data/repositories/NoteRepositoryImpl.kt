package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.models.Note as StorageNoteModel
import com.example.cleanarchitecture.domain.models.Note as DomainNoteModel
import com.example.cleanarchitecture.domain.repositories.NoteRepository

// this repository implementation use shared preferences

class NoteRepositoryImpl(private val noteStorage: NoteStorage) : NoteRepository {

    override fun saveNote(note: DomainNoteModel): Boolean {
        val dataLayerNoteModel = StorageNoteModel(note.text)
        return noteStorage.saveNote(dataLayerNoteModel)
    }

    override fun getNote(): DomainNoteModel {
        val dataLayerNoteModel = noteStorage.getNote()
        return DomainNoteModel(dataLayerNoteModel.text)
    }

}