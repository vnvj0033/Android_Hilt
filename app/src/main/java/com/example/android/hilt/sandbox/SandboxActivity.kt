package com.example.android.hilt.sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.hilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SandboxActivity : AppCompatActivity() {

    @Inject lateinit var sandboxModel: SandboxModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandbox)

        Log.d("testsyyoo", sandboxModel.toString())
    }
}