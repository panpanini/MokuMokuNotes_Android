package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*


class NoteRepository {
    private val notes = MutableLiveData<List<Note>>()

    init {
        notes.value = listOf(
                Note("Skype family for Christmas", Date().apply { time = 1514203200 }),
                Note("Visit Shrine for 初詣", Date().apply { time = 1514764799 })
        )
    }

    fun getNotes(): LiveData<List<Note>> {
        return notes
    }

    fun saveNote(note: Note) {
        notes.value = notes.value?.plus(note) ?: listOf(note)
    }
}