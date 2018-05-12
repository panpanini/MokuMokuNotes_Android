package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*


class NoteRepository {

    private val items = mutableListOf(
                Note("Skype family for Christmas", Date().apply { time = 1514203200 }),
                Note("Visit Shrine for 初詣", Date().apply { time = 1514764799 }),
                Note("Add a new note with the + button ↑", Date().apply { System.currentTimeMillis() })
    )

    private val notes = MutableLiveData<List<Note>>()

    fun getNotes(): LiveData<List<Note>> {
        notes.value = items

        return notes
    }

    fun saveNote(note: Note) {
        items.add(note)
        notes.value = items
    }

}