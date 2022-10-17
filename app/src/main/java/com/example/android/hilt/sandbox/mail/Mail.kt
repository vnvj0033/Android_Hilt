package com.example.android.hilt.sandbox.mail

import com.example.android.hilt.sandbox.user.User
import javax.inject.Inject

class Mail @Inject constructor(
    private val title: String,
    private val body: String
) {
    @MailScope
    @Inject lateinit var user: User

    override fun toString(): String {
        return "Mail{title:$title , body:$body}"
    }
}