package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import java.util.*

class NoteViewModel(private val repository: NoteRepository = NoteRepository()): ViewModel() {


    val notes: LiveData<List<Note>> = Transformations.map(repository.getNotes()) { it }

    fun saveNote(text: String) {
        val note = Note(text, Date())
        repository.saveNote(note)
    }
}