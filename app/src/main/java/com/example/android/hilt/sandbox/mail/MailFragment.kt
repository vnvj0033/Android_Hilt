package com.example.android.hilt.sandbox.mail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@AndroidEntryPoint
class MailFragment : Fragment(), MailAction {

    lateinit var mail: Mail

    @Inject lateinit var builder: UserComponent.Builder

    private lateinit var repo: MailRepo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val component = builder.setEvent(this).build()
        repo = EntryPoints.get(component, UserEntryPoint::class.java).getRepo()
        mail = EntryPoints.get(component, UserEntryPoint::class.java).getMail()
        repo.sendMail()

    }

    override fun sendMail() {
        Log.d("testsyyoo", mail.toString())
    }

}

interface MailAction {
    fun sendMail()
}

class MailRepo @Inject constructor(private var action: MailAction) {
    fun sendMail() {
        action.sendMail()
    }
}

@DefineComponent(parent = SingletonComponent::class)
interface UserComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setEvent(@BindsInstance action: MailAction): Builder
        fun build(): UserComponent
    }
}

@EntryPoint
@InstallIn(UserComponent::class)
interface UserEntryPoint {
    fun getRepo(): MailRepo
    fun getMail(): Mail
}
