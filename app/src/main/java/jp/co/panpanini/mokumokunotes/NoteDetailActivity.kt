package jp.co.panpanini.mokumokunotes

import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

/**
 * Created by tksk_mba on 2018/02/04.
 */
class NoteDetailActivity : AppCompatActivity() {
    val noteTitleView by lazy { findViewById<TextView>(R.id.note_detail_title) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val noteTitle = intent.getStringExtra(EXTRA_NOTE_TITLE)
        noteTitleView.text = noteTitle
    }

    companion object {
        private val EXTRA_NOTE_TITLE = NoteDetailActivity::class.java.simpleName + "extra.noteTitle"

        @JvmStatic
        fun createIntent(context: Context, noteTitle: String)
                = Intent(context, NoteDetailActivity::class.java).apply { putExtra(EXTRA_NOTE_TITLE, noteTitle) }
    }
}