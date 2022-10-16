package com.example.android.hilt.sandbox.mail

import javax.inject.Inject

class MailPresenter @Inject constructor(val repo: MailRepo) {

    fun sendMail() {
        repo.sendMail()
    }
}