package com.example.android.hilt.sandbox.mail

import com.example.android.hilt.sandbox.user.User
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@DefineComponent(parent = ActivityComponent::class)
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
    fun getAction(): MailAction
}

@Module
@InstallIn(ActivityComponent::class)
class SandboxEntryModule {

    @Provides
    fun component(builder: MailComponent.Builder) = EntryPoints.get(builder.setEvent(object : MailAction{
        override fun mailInfo() {

        }
    }).build(), UserEntryPoint::class.java).getAction()

    @Provides
    @Singleton
    fun provideMail() = Mail("name", "message")
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


@Qualifier
annotation class MailTestScope