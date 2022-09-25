package com.example.android.hilt.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.android.hilt.R
import com.example.android.hilt.sandbox.mail.MailFragment
import com.example.android.hilt.sandbox.user.UserFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SandboxActivity : AppCompatActivity() {

    @Inject lateinit var sandboxModel: SandboxModel

    @MailScope
    @Inject
    lateinit var mailFragment: MailFragment

    @UserScope
    @Inject
    lateinit var userFragment: UserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandbox)

        Log.d("testsyyoo", sandboxModel.toString())

        mailFragment.show()
        userFragment.show()
    }

    private fun Fragment.show() =
        supportFragmentManager.beginTransaction().replace(R.id.container, this)
            .commit()

}