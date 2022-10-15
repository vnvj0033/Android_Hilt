package com.example.android.hilt.sandbox.mail

import javax.inject.Inject


class MailRepo @Inject constructor(private var action: MailAction) {
    fun sendMail() {
        action.sendMail()
    }
}
