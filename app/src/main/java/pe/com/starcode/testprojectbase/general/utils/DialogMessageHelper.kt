package pe.com.starcode.testprojectbase.general.utils

import androidx.fragment.app.FragmentManager
import pe.com.starcode.testprojectbase.alertMessage.MessageDialogFragment

class DialogMessageHelper {

    fun messageDefaultWithButtonDialog(
        title: String,
        message: String,
        isCancelable: Boolean = false,
        childFragmentManager: FragmentManager,
        textButtonAccept: String = "",
        textButtonCancel: String = "",
        actionAccept: () -> Unit?
    ) {

        val dialog = MessageDialogFragment.newInstance(
            title,
            message,
            isCancelable,
            false,
            textButtonAccept,
            textButtonCancel
        )

        dialog.setListener(object : MessageDialogFragment.OnMessageDialogListener {
            override fun onAccept() {
                actionAccept()
            }
        })

        dialog.show(childFragmentManager, "MessageDialogFragment")
    }

    fun messageDefaultDialog(
        title: String,
        message: String,
        childFragmentManager: FragmentManager
    ) {
        val dialog = MessageDialogFragment.newInstance(
            title,
            message,
            isCancelable = false,
            hasTimeLimit = true,
            textButtonAccept = null,
            textButtonCancel = null
        )
        dialog.show(childFragmentManager, "MessageDialogFragment")
    }
}