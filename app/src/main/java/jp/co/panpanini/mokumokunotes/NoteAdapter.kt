package jp.co.panpanini.mokumokunotes

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class NoteAdapter(private val onItemClick: (Note) -> Unit): RecyclerView.Adapter<NoteViewHolder>() {

    private val items = mutableListOf<Note>()

    fun addNotes(notes: List<Note>) {
        // For extra points, you could look at implementing DiffUtil here:
        // http://blog.takuji31.jp/entry/kanmoba17
        items.clear()
        items.addAll(notes)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
            NoteViewHolder.create(parent, onItemClick)

    override fun onBindViewHolder(holder: NoteViewHolder?, position: Int) {
        holder?.bind(items[position])
    }
}