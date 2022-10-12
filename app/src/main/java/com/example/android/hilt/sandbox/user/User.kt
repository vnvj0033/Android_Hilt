package com.example.android.hilt.sandbox.user

import javax.inject.Inject


data class User @Inject constructor(val name: String)