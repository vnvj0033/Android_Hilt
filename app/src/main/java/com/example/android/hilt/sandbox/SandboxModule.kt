package com.example.android.hilt.sandbox

import com.example.android.hilt.sandbox.mail.Mail
import com.example.android.hilt.sandbox.mail.MailFragment
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
}

@Module
@InstallIn(SingletonComponent::class)
class SandboxMailModule {

    @MailScope
    @Provides
    fun providesMailFragment() = MailFragment()

    @MailScope
    @Provides
    fun providesMailUser() = User("mail user name")

    @Provides
    fun provideSandboxModel() = SandboxModel("base name", 1)

    @MailScope
    @Provides
    fun providesMail() = Mail("mail name", "body")
}


@Module
@InstallIn(SingletonComponent::class)
class SandboxEntryModule {

    @Provides
    fun name() = "name"

    @Provides
    fun mes() = "message"

    @Provides
    fun mail() = Mail("123", "123")
}

@Qualifier
annotation class MailScope

@Qualifier
annotation class UserScope