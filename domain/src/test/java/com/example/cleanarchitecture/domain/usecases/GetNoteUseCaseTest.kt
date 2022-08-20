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
    fun `should return the same data as in repository`() {

        val testNote = Note(text = "test note")
        Mockito.`when`(noteRepository.getNote()).thenReturn(testNote)

        val useCase = GetNoteUseCase(noteRepository = noteRepository)
        val actual = useCase.execute()
        val expected = Note(text = "test note")

        Assertions.assertEquals(expected, actual)

    }

}

