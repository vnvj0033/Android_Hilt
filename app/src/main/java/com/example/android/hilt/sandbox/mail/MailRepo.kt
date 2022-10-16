package com.example.android.hilt.sandbox.mail

import android.util.Log
import javax.inject.Inject


class MailRepo @Inject constructor(private var action: MailAction) {
    init {
        Log.d("MailRepo-hash", hashCode().toString())
    }
    fun sendMail() {
        action.mailInfo()
    }
}
