package jp.co.panpanini.mokumokunotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    Quest 1: Run the project!
    /*
    There are several quests in this project to help you on your way! look for TODO comments to
    find your way.

    Some useful keyboard shortcuts:
    Run project ( CTRL + R )
    Search project for keyword ( ⌘ + Shift + F )
    Search project for class ( ⌘ + O )
    Open recent files ( ⌘ + E )
    Comment line ( ⌘ + / )
    View Logcat ( ⌘ + 6 )

    First, lets clear the compile error by deleting the line before this comment.

    Helpful hints:

    Logcat is like the Xcode console - it will show you runtime errors.
     */


    // onCreate → viewDidLoad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            transitionToList()
        }
    }

    fun transitionBack() {
        supportFragmentManager.popBackStack()
    }

    private fun transitionToList() {
        val fragment = NoteListFragment.create()
        showFragment(fragment, "list")
    }

    fun transitionToDetail(note: Note) {
        val fragment = NoteDetailFragment.create(note)
        showFragment(fragment, "detail", true)
    }

    fun transitionToCreate() {
        val fragment = NoteCreateFragment.create()
        showFragment(fragment, "create", true)
    }

    /**
     * Show a fragment inside our MainActivity's content window
     */
    private fun showFragment(fragment: Fragment, tag: String? = null, addToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, fragment, tag).apply {
                if (addToBackStack) {
                    addToBackStack(tag)
                }
            }
            .commit()
    }

}
