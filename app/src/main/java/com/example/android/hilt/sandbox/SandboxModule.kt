package com.example.android.hilt.sandbox

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SandboxModule {

    @Provides
    fun provideSandboxModel() = SandboxModel("base name", 0)
}