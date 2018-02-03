package jp.co.panpanini.mokumokunotes

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_note.view.*

class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener { /*Log.d("NoteViewHolder", "onClick")*/ }
    }

    private val label = view.label

    fun bind(note: Note) {
        label.text = note.text
    }

    companion object {
        fun create(parent: ViewGroup) = NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_note, parent, false))
    }

}