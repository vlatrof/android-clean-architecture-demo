package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase

class MainActivity : AppCompatActivity() {

    private val getNoteUseCase = GetNoteUseCase()
    private val saveNoteUseCase = SaveNoteUseCase()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetNote.setOnClickListener { btnGetNoteOnClick() }
        binding.btnSaveNote.setOnClickListener { btnSaveNoteOnClick() }

    }

    private fun btnGetNoteOnClick() {
        val data = getNoteUseCase.execute()
        renderNote(data)
    }

    private fun btnSaveNoteOnClick() {
        val data = Note(binding.etInputNote.text.toString())
        saveNoteUseCase.execute(data)
    }

    private fun renderNote(note: Note) {

        if (note.value == "") {
            binding.tvNote.text = getString(R.string.tv_note_placeholder_text)
            return
        }

        binding.tvNote.text = note.value
    }

}