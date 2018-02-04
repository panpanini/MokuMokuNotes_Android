package jp.co.panpanini.mokumokunotes

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class NoteAdapter(val noteSelectedListener: NoteViewHolder.NoteSelectedListener): RecyclerView.Adapter<NoteViewHolder>() {

    private val items = mutableListOf<Note>()

    fun addNotes(notes: List<Note>) {
        //TODO: use DiffUtils here
        items.clear()
        items.addAll(notes)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
            NoteViewHolder.create(parent, noteSelectedListener)

    override fun onBindViewHolder(holder: NoteViewHolder?, position: Int) {
        holder?.bind(items[position])
    }
}