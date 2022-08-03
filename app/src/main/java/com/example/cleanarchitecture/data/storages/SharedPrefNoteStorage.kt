package com.example.cleanarchitecture.data.storages

import android.content.Context
import com.example.cleanarchitecture.data.storages.models.Note
import com.example.cleanarchitecture.presentation.App

class SharedPrefNoteStorage(context: Context) : NoteStorage {

    private val sharedPreferences =
        context.getSharedPreferences(App.APP_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveNote(note: Note): Boolean {

        sharedPreferences.edit().putString(App.APP_SHARED_PREFERENCES_NOTE_TAG, note.text).apply()
        return true

    }

    override fun getNote(): Note {

        val noteValue=
            sharedPreferences.getString(App.APP_SHARED_PREFERENCES_NOTE_TAG,
                App.APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE)
            ?: App.APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE

        return Note(text = noteValue)

    }


}