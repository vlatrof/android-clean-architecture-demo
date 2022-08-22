package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repositories.NoteRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never

class SaveNoteUseCaseTest {

    private val noteRepository = mock<NoteRepository>()

    @AfterEach
    private fun tearDown() {
        Mockito.reset(noteRepository)
    }

    @Test
    fun `should not attempt to save note value if such note value saved already`() {

        val testNoteSaved = Note(text = "dummy note")
        val testNoteToSave = Note(text = "dummy note")

        Mockito.`when`(noteRepository.getNote()).thenReturn(testNoteSaved)
        val saveNoteUseCase = SaveNoteUseCase(noteRepository = noteRepository)

        saveNoteUseCase.execute(testNoteToSave)
        Mockito.verify(noteRepository, never()).saveNote(note = any())

    }

    @Test
    fun `should return true if save was successful`() {

        val testNoteSaved = Note(text = "dummy note first")
        val testNoteToSave = Note(text = "dummy note second")
        val expected = true

        Mockito.`when`(noteRepository.getNote()).thenReturn(testNoteSaved)
        Mockito.`when`(noteRepository.saveNote(testNoteToSave)).thenReturn(expected)
        val saveNoteUseCase = SaveNoteUseCase(noteRepository = noteRepository)

        val actual = saveNoteUseCase.execute(testNoteToSave)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(noteRepository, Mockito.times(1)).saveNote(testNoteToSave)

    }

}