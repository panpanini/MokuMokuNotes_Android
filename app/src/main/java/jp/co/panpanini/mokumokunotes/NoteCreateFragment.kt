package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_note_create.*

class NoteCreateFragment: Fragment() {


    private val noteEditText: EditText
    // using android-kotlin-extensions, we can just write the ID of the view
        get() = note_edit_text

    private val viewModel by lazy {
        // By using the activity to get the ViewModel, we can share the instance with the list fragment
        ViewModelProviders.of(activity!!).get(NoteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        TODO("lets inflate the view here. we should use R.layout.fragment_note_create")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (menu == null) return
        inflater?.inflate(R.menu.create_note_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.save -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
//        val note = noteEditText.text.toString()

        TODO("save the item in the ViewModel, and return to the list")

        (activity as? MainActivity)?.transitionBack()
    }

    companion object {
        @JvmStatic
        fun create() = NoteCreateFragment()
    }
}