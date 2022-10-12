package com.example.android.hilt.sandbox.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.hilt.sandbox.UserScope
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("testsyyoo", "in user")
        Log.d("testsyyoo", user.toString())

        EntryPoints.get(requireContext().applicationContext, UserEvent::class.java).userUpdate()

    }

    override fun userUpdate() {
        Log.d("testsyyoo - userUpdate", "yeah")
    }

    @InstallIn(SingletonComponent::class)
    @EntryPoint
    interface UserEntryPoint {
        fun userEvent(): UserEvent
    }
}

interface UserEvent {
    fun userUpdate()
}

class UserRepo(private val userEvent: UserEvent) {

    fun run() {
        userEvent.userUpdate()
    }

}