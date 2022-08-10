package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repositories.NoteRepositoryImpl
import com.example.cleanarchitecture.data.storages.sharedprefs.SharedPrefNoteStorage
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val noteStorage by lazy { SharedPrefNoteStorage(context) }
    private val noteRepository by lazy { NoteRepositoryImpl(noteStorage) }
    private val saveNoteUseCase by lazy { SaveNoteUseCase(noteRepository) }
    private val getNoteUseCase by lazy { GetNoteUseCase(noteRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(saveNoteUseCase, getNoteUseCase) as T
    }

}