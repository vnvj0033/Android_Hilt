package com.example.android.hilt.sandbox

import javax.inject.Inject

data class SandboxModel @Inject constructor(
    val name: String,
    val version: Int
)
