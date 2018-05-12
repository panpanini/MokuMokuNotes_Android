package jp.co.panpanini.mokumokunotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.*

class NoteListFragment: Fragment() {

    private val recyclerView: RecyclerView
        get() = view!!.findViewById(R.id.recycler_view)

    private val noteAdapter by lazy {
        // we create the adapter, and set the transitionToNotDetail function as the item click listener
        NoteAdapter(this::transitionToNoteDetail)
    }

    private val viewModel by lazy {
        // The lazy delegate will run this block once, and then cache the result.
        // We can use this to lazy init the ViewModel after the Activity has been created.
        ViewModelProviders.of(activity!!).get(NoteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_note_list, container, false)


    // onViewCrated → viewDidLoad (almost)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        // A RecyclerView is like a UITableView,
        // and an adapter is like a UITableViewDataSource.
        recyclerView.adapter = noteAdapter


        setupBindings()

    }

    private fun setupBindings() {
        //TODO Quest 2: bind the ViewModel
        // Did you notice nothing was being displayed? We should Observe our ViewModel, to get
        // Updates when the data changes.
//        viewModel.notes.observe(this, Observer {
//                noteAdapter.addNotes(it)
//        })

        // Even if we uncomment the code, it doesn't compile right?
        // Thats because the types mismatch - the Observer is providing a nullable List, but
        // the NoteAdapter expects a non-null list. We can use the `let` scope function to
        // perform this null check! Have a look at the following link for more information
        // https://qiita.com/ngsw_taro/items/d29e3080d9fc8a38691e
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.let { inflater?.inflate(R.menu.note_list_menu, menu) }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // we must return a boolean to say that this menu item click was handled
        return when (item?.itemId) {
            R.id.add_note -> {
                TODO("we should show the Add Note Fragment here")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun transitionToNoteDetail(note: Note) {
        TODO("transition to note detail")
    }

    private fun transitionToAddNote() {
        // Note: This isn't an ideal implementation, because it creates an implicit dependency
        // on the MainActivity. It would be better to create an interface or something and
        // use that instead
        (activity as? MainActivity)?.transitionToCreate()
    }

    companion object {
        @JvmStatic
        fun create() = NoteListFragment()
    }

}