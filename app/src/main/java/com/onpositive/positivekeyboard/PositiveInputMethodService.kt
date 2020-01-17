package com.onpositive.positivekeyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.text.TextUtils
import android.view.View


class PositiveInputMethodService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    override fun onCreateInputView(): View {
        val keyboardView = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView
        val keyboard = Keyboard(this, R.xml.number_pad)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    override fun swipeRight() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPress(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRelease(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeLeft() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun swipeDown() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onKey(p0: Int, p1: IntArray?) {
        val inputConnection = currentInputConnection
        if (inputConnection != null) {
            when (p0) {
                Keyboard.KEYCODE_DELETE -> {
                    val selectedText = inputConnection.getSelectedText(0)
                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0)
                    } else {
                        inputConnection.commitText("", 1)
                    }
                }
                else -> {
                    val code = p0 as Char
                    inputConnection.commitText(code.toString(), 1)
                }
            }
        }
    }

    override fun onText(p0: CharSequence?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}