package com.example.android.hilt.sandbox.mail

import com.example.android.hilt.sandbox.user.User

class Mail(
    private val title: String,
    private val body: String
): MailUser {
    lateinit var user: User

    override fun getUserInfo() = user.toString()

}


interface MailUser {
    fun getUserInfo(): String
}