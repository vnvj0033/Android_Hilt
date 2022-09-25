package com.example.android.hilt.sandbox

import com.example.android.hilt.sandbox.mail.MailFragment
import com.example.android.hilt.sandbox.user.UserFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SandboxModule {

    @Provides
    fun providesMailFragment() = MailFragment()

    @Provides
    fun providesUserFragment() = UserFragment()

    @Provides
    fun provideSandboxModel() = SandboxModel("base name", 1)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class SandboxBindModule {

    @Binds
    abstract fun bindSandboxModel(name: SandboxModel): SandboxModelInterface

}