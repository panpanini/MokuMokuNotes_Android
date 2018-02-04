package jp.co.panpanini.mokumokunotes

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText

class InputDialogFlagment : DialogFragment() {
    var onOk : ((String) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val editText = EditText(activity)
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("ノートのタイトル")
                .setView(editText)
                .setPositiveButton("OK", { _, _ ->
                    onOk?.let { it(editText.text.toString()) }
                })
                .setNegativeButton("キャンセル", DialogInterface.OnClickListener { _, _ -> })
        return builder.create()
    }

    override fun onPause() {
        super.onPause()
        // onPause でダイアログを閉じる場合
        dismiss()
    }
}