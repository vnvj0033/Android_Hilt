package com.example.android.hilt.sandbox.mail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * MailFragment --------------------
 * |
 * |    MailPresenter --------------|
 * |    |                           |
 * |    |   MailRepository ----|    |
 * |    |   |------------------|    |
 * |    |                           |
 * |    |---------------------------|
 *
 *
 * */

@AndroidEntryPoint
class MailFragment : Fragment(), MailAction {

    @Inject lateinit var builder: MailComponent.Builder

    private lateinit var presenter: MailPresenter
    private lateinit var repo: MailRepo
    private lateinit var mail: Mail

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val component = builder.setEvent(this).build()
        val userEntryPoint = EntryPoints.get(component, UserEntryPoint::class.java)

        presenter.sendMail()

    }

    override fun mailInfo() {
        Log.d("testsyyoo", "send mail! : $mail")
    }

}
