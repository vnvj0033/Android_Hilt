package com.example.android.hilt.sandbox.user

import android.content.Context
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

    private val userRepo = UserRepo()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRepo.run(requireContext().applicationContext)
    }

    override fun userUpdate() {
        Log.d("testsyyoo - userUpdate", "yeah")
    }


}

interface UserEvent {
    fun userUpdate()
}

class UserRepo {

    fun run(context: Context) {
        Log.d("testsyyoo - run", EntryPoints.get(context, UserEntryPoint::class.java).userEvent().name)
    }

    @InstallIn(SingletonComponent::class)
    @EntryPoint
    interface UserEntryPoint {
        fun userEvent(): User
    }

}