package com.example.cleanarchitecture.data.storages.sharedprefs

import android.content.Context
import com.example.cleanarchitecture.data.storages.NoteStorage
import com.example.cleanarchitecture.data.storages.models.Note

class SharedPrefNoteStorage(context: Context) : NoteStorage {

    private val sharedPreferences =
        context.getSharedPreferences(APP_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveNote(note: Note): Boolean {
        sharedPreferences.edit().putString(APP_SHARED_PREFERENCES_NOTE_TAG, note.text).apply()
        return true
    }

    override fun getNote(): Note {
        val noteValue =
            sharedPreferences.getString(
                APP_SHARED_PREFERENCES_NOTE_TAG,
                APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE
            )
                ?: APP_SHARED_PREFERENCES_NOTE_DEFAULT_VALUE

        return Note(text = noteValue)
    }
}
