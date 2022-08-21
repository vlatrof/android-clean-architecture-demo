package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.repositories.NoteRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetNoteUseCaseTest {

    private val noteRepository = mock<NoteRepository>()

    @Test
    fun `should return the same note value as in repository`() {

        val testNoteSaved = Note(text = "dummy note")
        val testNoteExpected = Note(text = "dummy note")

        Mockito.`when`(noteRepository.getNote()).thenReturn(testNoteSaved)
        val getNoteUseCase = GetNoteUseCase(noteRepository = noteRepository)

        val actual = getNoteUseCase.execute()

        Assertions.assertEquals(testNoteExpected, actual)

    }

}

