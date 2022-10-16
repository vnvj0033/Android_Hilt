package com.example.android.hilt.sandbox.mail

import android.util.Log
import javax.inject.Inject

class MailPresenter @Inject constructor(private val repo: MailRepo) {

    init {
        Log.d("hashCode", hashCode().toString())
    }

    fun sendMail() {
        repo.sendMail()
    }
}