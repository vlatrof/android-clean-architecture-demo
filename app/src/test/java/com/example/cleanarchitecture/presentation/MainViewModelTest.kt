package com.example.cleanarchitecture.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.example.cleanarchitecture.domain.models.Note
import com.example.cleanarchitecture.domain.usecases.GetNoteUseCase
import com.example.cleanarchitecture.domain.usecases.SaveNoteUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class MainViewModelTest {

    private val saveNoteUseCase = mock<SaveNoteUseCase>()
    private val getNoteUseCase = mock<GetNoteUseCase>()

    @AfterEach
    fun afterEach() {
        Mockito.reset(saveNoteUseCase)
        Mockito.reset(getNoteUseCase)
    }

    @BeforeEach
    fun beforeEach() {

        ArchTaskExecutor.getInstance().setDelegate(object: TaskExecutor(){
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

        })

    }

    @Test
    fun `should put true in saveResultLiveData after saving note successfully`() {

        val noteToSave = Note(text = "dummy note")

        Mockito.`when`(saveNoteUseCase.execute(note = noteToSave)).thenReturn(true)

        val mainViewModel = MainViewModel(
            saveNoteUseCase = saveNoteUseCase,
            getNoteUseCase = getNoteUseCase
        )

        mainViewModel.saveNote(noteToSave)

        val expected = true
        val actual = mainViewModel.saveResultLiveData.value

        Assertions.assertEquals(expected, actual)

    }

    @Test
    fun `should put note in noteLiveData after loading note successfully`() {

        val noteToGet = Note(text = "dummy note")

        Mockito.`when`(getNoteUseCase.execute()).thenReturn(noteToGet)

        val mainViewModel = MainViewModel(
            saveNoteUseCase = saveNoteUseCase,
            getNoteUseCase = getNoteUseCase
        )

        mainViewModel.getNote()

        val expected = noteToGet
        val actual = mainViewModel.noteLiveData.value

        Assertions.assertEquals(expected, actual)

    }

}