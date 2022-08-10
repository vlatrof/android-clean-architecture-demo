package com.example.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainViewModel(

    private val saveNoteUseCase: SaveNoteUseCase,
    private val getNoteUseCase: GetNoteUseCase,

) : ViewModel() {

    private val saveResultMutableLiveData = MutableLiveData<Boolean>()
    private val noteMutableLiveData = MutableLiveData<Note>()

    // to prevent changing MutableLiveData.value from activity
    val saveResultLiveData = saveResultMutableLiveData
    val noteLiveData = noteMutableLiveData


    fun saveNote(note: Note) {
        saveResultMutableLiveData.value = saveNoteUseCase.execute(note)
    }

    fun getNote() {
        noteMutableLiveData.value = getNoteUseCase.execute()
    }

}