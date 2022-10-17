package com.example.android.hilt.sandbox.mail

import com.example.android.hilt.sandbox.user.User
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@DefineComponent(parent = SingletonComponent::class)
interface MailComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setEvent(@BindsInstance action: MailAction): Builder
        fun build(): MailComponent
    }
}

@EntryPoint
@InstallIn(MailComponent::class)
interface UserEntryPoint {
    fun getPresenter(): MailPresenter
    fun getRepo(): MailRepo
    fun getMail(): Mail
}

@Module
@InstallIn(MailComponent::class)
class SandboxEntryModule {

    @Named("name")
    @Provides
    fun provideName() = "name"

    @Named("message")
    @Provides
    fun provideMessage() = "message"

    @Provides
    fun provideMail(
        @Named("name") name: String,
        @Named("message") message: String
    ) = Mail(name, message)
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


    @MailScope
    @Provides
    fun providesMail() = Mail("mail name", "body")
}

@Qualifier
annotation class MailScope