package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.Note
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]
        mainViewModel.noteLiveData.observe(this) { onChangeNoteLiveData(it) }

        binding.btnGetNote.setOnClickListener { onClickBtnGetNote() }
        binding.btnSaveNote.setOnClickListener { onClickBtnSaveNote() }
    }

    private fun onChangeSaveNoteResult(saveResult: Boolean) {
        Toast.makeText(this, "Note saved: $saveResult", Toast.LENGTH_SHORT).show()
    }

    private fun onChangeNoteLiveData(note: Note) {
        renderNote(note)
    }

    private fun onClickBtnGetNote() {
        mainViewModel.getNote()
    }

    private fun onClickBtnSaveNote() {
        val noteToSave = Note(binding.etInputNote.text.toString())
        mainViewModel.saveNote(noteToSave)
        mainViewModel.saveResultLiveData.observe(this) { onChangeSaveNoteResult(it) }
    }

    private fun renderNote(note: Note) {
        if (note.text == "") {
            binding.tvNote.text = getString(R.string.tv_note_placeholder_text)
            return
        }
        binding.tvNote.text = note.text
    }
}
