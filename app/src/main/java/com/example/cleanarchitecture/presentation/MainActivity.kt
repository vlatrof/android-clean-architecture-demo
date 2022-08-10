package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.Note

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        mainViewModel.saveResultLiveData.observe(this) { saveResultLiveDataOnChange(it) }
        mainViewModel.noteLiveData.observe(this) { noteLiveDataOnChange(it) }

        binding.btnGetNote.setOnClickListener { btnGetNoteOnClick() }
        binding.btnSaveNote.setOnClickListener { btnSaveNoteOnClick() }

    }

    private fun saveResultLiveDataOnChange(saveResult: Boolean) {
        renderString("Note saved: $saveResult")
    }

    private fun noteLiveDataOnChange(note: Note) {
        renderNote(note)
    }

    private fun btnGetNoteOnClick() {
        mainViewModel.getNote()
    }

    private fun btnSaveNoteOnClick() {
        val noteToSave = Note(binding.etInputNote.text.toString())
        mainViewModel.saveNote(noteToSave)
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