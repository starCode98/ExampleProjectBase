package pe.com.starcode.testprojectbase.alertMessage

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.com.starcode.testprojectbase.databinding.DialogFragmentMessageBinding
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.BODY
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.HAS_TIME_LIMIT
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.IS_CANCELABLE
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.TEXT_BUTTON_ACCEPT
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.TEXT_BUTTON_CANCEL
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.TIME
import pe.com.starcode.testprojectbase.general.utils.Constants.DefaultDialogMessage.TITLE

class MessageDialogFragment : DialogFragment() {


    private val binding: DialogFragmentMessageBinding by lazy {
        DialogFragmentMessageBinding.inflate(layoutInflater)
    }

    private lateinit var title: String
    private lateinit var message: String
    private lateinit var textButtonCancel: String
    private lateinit var textButtonAccept: String
    private var optionIsCancelable: Boolean = true
    private var limitTime: Boolean = false

    //listener
    private lateinit var listener: OnMessageDialogListener

    companion object {

        fun newInstance(
            title: String,
            message: String,
            isCancelable: Boolean = true,
            hasTimeLimit: Boolean = false,
            textButtonAccept: String?,
            textButtonCancel: String?,
        ) = MessageDialogFragment().apply {
            arguments = Bundle().apply {
                putString(TITLE, title)
                putString(BODY, message)
                putBoolean(IS_CANCELABLE, isCancelable)
                putString(TEXT_BUTTON_CANCEL, textButtonCancel)
                putString(TEXT_BUTTON_ACCEPT, textButtonAccept)
                putBoolean(HAS_TIME_LIMIT, hasTimeLimit)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        arguments?.let {
            title = it.getString(TITLE, "")
            message = it.getString(BODY, "")
            optionIsCancelable = it.getBoolean(IS_CANCELABLE)
            textButtonAccept = it.getString(TEXT_BUTTON_ACCEPT, "")
            textButtonCancel = it.getString(TEXT_BUTTON_CANCEL, "")
            limitTime = it.getBoolean(HAS_TIME_LIMIT)
        }

        binding.apply {
            textViewTitle.text = title
            textViewMessage.text = message

            if (textButtonCancel.isNotEmpty()) {
                buttonCancel.text = textButtonCancel
            }

            if (textButtonAccept.isNotEmpty()) {
                buttonAccept.text = textButtonAccept
            }

            buttonCancel.isVisible = !limitTime
            buttonAccept.isVisible = !limitTime

            if (!limitTime) {
                isCancelable = optionIsCancelable
                buttonCancel.isVisible = optionIsCancelable
            } else {
                isCancelable = false
                GlobalScope.launch {
                    delay(TIME)
                    dismiss()
                }
            }

            buttonCancel.setOnClickListener {
                dismiss()
            }
            buttonAccept.setOnClickListener {
                listener.onAccept()
                dismiss()
            }
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let {
//            it.attributes.windowAnimations = R.style.DialogAnimation
            it.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
    }

    interface OnMessageDialogListener {
        fun onAccept()
    }

    fun setListener(listener: OnMessageDialogListener) {
        this.listener = listener
    }

}