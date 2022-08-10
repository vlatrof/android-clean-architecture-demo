package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.Note

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetNote.setOnClickListener { btnGetNoteOnClick() }
        binding.btnSaveNote.setOnClickListener { btnSaveNoteOnClick() }
    }

    private fun btnGetNoteOnClick() {
        val resultNote = mainViewModel.getNote()
        renderNote(resultNote)
    }

    private fun btnSaveNoteOnClick() {
        val note = Note(binding.etInputNote.text.toString())
        val saveResult = mainViewModel.saveNote(note)
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