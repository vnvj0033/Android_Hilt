package com.example.android.hilt.sandbox.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.hilt.sandbox.UserScope
import javax.inject.Inject

class UserFragment : Fragment() {

    @UserScope
    @Inject lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("testsyyoo", "in user")
        Log.d("testsyyoo", user.toString())
    }
}
