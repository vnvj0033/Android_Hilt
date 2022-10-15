package com.example.android.hilt.sandbox.mail

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
    fun getRepo(): MailRepo
    fun getMail(): Mail
}
