package com.example.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainViewModel(

    private val saveNoteUseCase: SaveNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase,

) : ViewModel() {

    fun saveNote(note: Note): Boolean {
        return saveNoteUseCase.execute(note)
    }

    fun getNote() : Note {
        return getNoteUseCase.execute()
    }

}