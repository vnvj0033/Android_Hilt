package com.example.android.hilt.sandbox

import com.example.android.hilt.sandbox.user.User
import com.example.android.hilt.sandbox.user.UserFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class SandboxUserModule {
    @UserScope
    @Provides
    fun providesUserFragment() = UserFragment()

    @UserScope
    @Provides
    fun providesUser() = User("user name")
    
    @Provides
    fun provideSandboxModel() = SandboxModel("base name", 1)
}

@Qualifier
annotation class UserScope