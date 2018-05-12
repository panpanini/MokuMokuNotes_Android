package jp.co.panpanini.mokumokunotes

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_note.view.*

class NoteViewHolder(view: View, private val onClick: (Note) -> Unit): RecyclerView.ViewHolder(view) {

    private val cardView = view
    private val label = view.label

    fun bind(note: Note) {
        label.text = note.text

        cardView.setOnClickListener { onClick(note) }
    }

    companion object {
        fun create(parent: ViewGroup, onClick: (Note) -> Unit)
                = NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_note, parent, false), onClick)
    }

}