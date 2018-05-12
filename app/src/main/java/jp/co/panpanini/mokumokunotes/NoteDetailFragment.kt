package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_note_detail.*

class NoteDetailFragment: Fragment() {

    private val note by lazy {
        arguments!!.getSerializable(NOTE) as Note
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NoteDetailViewModel::class.java)
    }

    private val noteText: TextView
        get() = note_text

    private val noteCreatedAt: TextView
        get() = created_at

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // we return false for attachToRoot so that we can remove the Fragment later
        return inflater.inflate(R.layout.fragment_note_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO: set the note to the ViewModel

        setupBindings()
    }

    private fun setupBindings() {
        viewModel.noteText.observe(this, Observer {
                noteText.text = it
        })

        //TODO observe viewModel.noteCreatedAt
    }

    companion object {
        private const val NOTE = "note"

        fun create(note: Note) = NoteDetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(NOTE, note)
            }
        }
    }
}