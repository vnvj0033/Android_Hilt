package com.example.android.hilt.sandbox

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class SandboxModule {

    @Provides
    fun provideSandboxModel() = SandboxModel("base name", 1)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class SandboxBindModule {

    @Binds
    abstract fun bindSandboxModel(name: SandboxModelImp): SandboxModelInterface

}

class SandboxModelImp @Inject constructor() : SandboxModelInterface {
    override fun nab() {

    }
}