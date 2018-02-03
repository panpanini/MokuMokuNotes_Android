package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*


class NoteRepository {
    private val dummyDataSource = DummyDataSource()


    private val notes = MutableLiveData<List<Note>>()

    fun getNotes(): LiveData<List<Note>> {
        notes.value = dummyDataSource.getNotes()

        return notes
    }

    fun saveNote(note: Note) {
        TODO("Not implemented")
    }




    private class DummyDataSource {
        fun getNotes(): List<Note> {
            return listOf(
                Note("Skype family for Christmas", Date().apply { time = 1514203200 }),
                Note("Visit Shrine for 初詣", Date().apply { time = 1514764799 })
            )
        }
    }


}