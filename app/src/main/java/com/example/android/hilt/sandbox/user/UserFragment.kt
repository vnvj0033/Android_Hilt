package com.example.android.hilt.sandbox.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.hilt.sandbox.UserScope
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment(), UserEvent {

    @UserScope
    @Inject lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(context)

    override fun userUpdate() {
        Log.d("testsyyoo - userUpdate", "yeah")
    }


}

interface UserEvent {
    fun userUpdate()
}
