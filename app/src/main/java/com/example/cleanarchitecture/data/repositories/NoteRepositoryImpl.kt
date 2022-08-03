package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.models.Note as StorageNoteModel
import com.example.cleanarchitecture.domain.models.Note as DomainNoteModel
import com.example.cleanarchitecture.domain.repositories.NoteRepository

class NoteRepositoryImpl(private val noteStorage: NoteStorage) : NoteRepository {

    override fun saveNote(note: DomainNoteModel): Boolean {
        return noteStorage.saveNote(mapToStorage(note))
    }

    override fun getNote(): DomainNoteModel {
        return mapToDomain(noteStorage.getNote())
    }

    private fun mapToStorage(note: DomainNoteModel): StorageNoteModel {
        return StorageNoteModel(note.text)
    }

    private fun mapToDomain(note: StorageNoteModel): DomainNoteModel {
        return DomainNoteModel(note.text)
    }

}