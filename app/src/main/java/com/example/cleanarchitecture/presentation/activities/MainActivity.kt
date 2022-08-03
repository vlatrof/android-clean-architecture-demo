package com.example.cleanarchitecture.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.repositories.NoteRepositoryImpl
import com.example.cleanarchitecture.data.storages.sharedprefs.SharedPrefNoteStorage
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainActivity : AppCompatActivity() {

    private val noteStorage by lazy { SharedPrefNoteStorage(applicationContext) }
    private val noteRepository by lazy { NoteRepositoryImpl(noteStorage) }
    private val getNoteUseCase by lazy { GetNoteUseCase(noteRepository) }
    private val saveNoteUseCase by lazy { SaveNoteUseCase(noteRepository) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetNote.setOnClickListener { btnGetNoteOnClick() }
        binding.btnSaveNote.setOnClickListener { btnSaveNoteOnClick() }

    }

    private fun btnGetNoteOnClick() {
        val resultNote = getNoteUseCase.execute()
        renderNote(resultNote)
    }

    private fun btnSaveNoteOnClick() {
        val note = Note(binding.etInputNote.text.toString())
        val saveResult = saveNoteUseCase.execute(note)
        renderString("Note saved: $saveResult")
    }

    private fun renderNote(note: Note) {

        if (note.text == "") {
            binding.tvNote.text = getString(R.string.tv_note_placeholder_text)
            return
        }

        renderString(note.text)
    }

    private fun renderString(str: String) {
        binding.tvNote.text = str
    }

}