package com.example.android.hilt.sandbox.mail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.hilt.sandbox.MailScope
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@AndroidEntryPoint
class MailFragment : Fragment(), MailAction {

    @MailScope
    @Inject lateinit var mail: Mail

    @Inject lateinit var builder: UserComponent.Builder

    @Inject lateinit var repo: MailRepo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = View(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        builder.setEvent(this).build()
        repo.sendMail()

    }

    override fun sendMail() {
        Log.d("testsyyoo", "sendMail")
    }

}

interface MailAction {
    fun sendMail()
}

class MailRepo(private var action: MailAction) {
    fun sendMail() {
        action.sendMail()
    }
}

@EntryPoint
@InstallIn(UserComponent::class)
interface UserEntryPoint {
    fun getRepo(): MailRepo
}

@Module
@InstallIn(SingletonComponent::class)
class MailModule {

    @Provides
    fun providesMailRepo(action: MailAction) = MailRepo(action)
}

@DefineComponent(parent = SingletonComponent::class)
interface UserComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setEvent(@BindsInstance action: MailAction): Builder
        fun build(): UserComponent
    }
}