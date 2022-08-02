package com.example.cleanarchitecture.data.repository

import android.content.Context
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repository.NoteRepository
import com.example.cleanarchitecture.presentation.App
import java.lang.IllegalStateException

// this repository implementation use shared preferences

class NoteRepositoryImpl(private val context: Context) : NoteRepository {

    private val sharedPreferences = context.getSharedPreferences(
        App.APP_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveNote(note: Note): Boolean {

        sharedPreferences
            .edit()
            .putString(App.APP_SHARED_PREFERENCES_NOTE_TAG, note.text)
            .apply()

        return true
    }

    override fun getNote(): Note {

        val noteValue = sharedPreferences.getString(App.APP_SHARED_PREFERENCES_NAME, "")
            ?: throw IllegalStateException("Null note text in shared preferences")

        return Note(text = noteValue)
    }

}