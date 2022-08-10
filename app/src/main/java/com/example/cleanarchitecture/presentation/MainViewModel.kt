package com.example.cleanarchitecture.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainViewModel(

    private val saveNoteUseCase: SaveNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase,

) : ViewModel() {

    val saveResultLiveData = MutableLiveData<Boolean>()
    val noteLiveData = MutableLiveData<Note>()

    fun saveNote(note: Note) {
        saveResultLiveData.value = saveNoteUseCase.execute(note)
    }

    fun getNote() {
        noteLiveData.value = getNoteUseCase.execute()
    }

}