package com.example.android.hilt.sandbox.mail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.hilt.sandbox.MailScope
import javax.inject.Inject

class MailFragment : Fragment() {

    @MailScope
    @Inject lateinit var mail: Mail

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("testsyyoo", "in mail")
        Log.d("testsyyoo", mail.toString())

    }
}