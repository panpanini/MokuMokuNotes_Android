package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class NoteDetailViewModel: ViewModel() {

    private val note =  MutableLiveData<Note>()

    val noteText = Transformations.map(note) {
        it.text
    }

    val noteCompleted = Transformations.map(note) {
        it.completed
    }

    val noteCreatedAt = Transformations.map(note) {
        it.createdAt
    }


    fun setNote(note: Note) {
        this.note.value = note
    }

}