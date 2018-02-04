package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.content.DialogInterface
import android.util.Log


class MainActivity : AppCompatActivity(), NoteViewHolder.NoteSelectedListener {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val noteAdapter by lazy {
        NoteAdapter(this)
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = noteAdapter

        viewModel.notes.observe(this, Observer {
            it?.let {
                noteAdapter.addNotes(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.note_menu, menu)
        // we must return a boolean to say we created the menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // we must return a boolean to say that this menu item click was handled
        return when (item?.itemId) {
            R.id.add_note -> {
                transitionToAddNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun noteSelected(text: String) {
        Log.d("MainActivity", text)
        startActivity(NoteDetailActivity.createIntent(this, text))
    }


    private fun transitionToAddNote() {
        val dialog = InputDialogFlagment()
        dialog.onOk = {
            viewModel.saveNote(it)
        }
        dialog.show(supportFragmentManager, "tag")
    }
}
