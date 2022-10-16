package com.example.android.hilt.sandbox.mail

import javax.inject.Inject

class MailPresenter @Inject constructor(private val repo: MailRepo) {

    fun sendMail() {
        repo.sendMail()
    }
}