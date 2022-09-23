
## Binds
```kotlin
interface ModelInterface {
    fun getModelInfo(): String
}

data class Model @Inject constructor() : ModelInterface {
    override fun getModelInfo() = "name version"
}

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    abstract fun bindModel(model: ModelImp): ModelInterface
}

// used
@Inject lateinit var model: Model  

```

## Hilt Module
생성자가 삽입될 수 없는 유형의 결합을 Hilt 모듈에 포함
@InstallIn : 요구사항을 지정
```kotlin
//@InstallIn 주석으로 요구사항을 지정
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    
}

```

## instance container hilt
애플리케이션 컨테이너에서 항상 같은 인스턴스를 제공
Activity 내부 동일 인스턴스는 @ActivityScoped를 사용 
```kotlin
@Singleton
class LoggerLocalDataSource @Inject constructor(private val logDao: LogDao)
```

##  provide dependencies
생성자에 @Inject 추가하여 주입 대상 알림
```kotlin
class LoggerLocalDataSource @Inject constructor(private val logDao: LogDao)
```

## inject filed
@Inject 로 필드 삽입
인스턴스는 onAttach에서 주입
```kotlin
@AndroidEntryPoint
class LogsFragment : Fragment() {
    @Inject lateinit var logger: LoggerLocalDataSource
    @Inject lateinit var dateFormatter: DateFormatter

}
```

## Hilt field injection
(Activity, Fragment, View, Service, BroadcastReceiver) 생명주기의 컨테이너 생성
```kotlin
@AndroidEntryPoint
class LogsFragment : Fragment()
```

## Hilt in Application class
App 생명주기의 컨테이너를 생성
```kotlin
@HiltAndroidApp
class LogApplication : Application()
```


# Using Hilt in your Android app

This folder contains the source code for the "Using Hilt in your Android app" codelab.<br />
https://developer.android.com/codelabs/android-hilt

The codelab is built in multiple GitHub branches:
* `main` is the codelab's starting point.
* `solution` contains the solution to this codelab.


# Introduction
Dependency injection is a technique widely used in programming and well suited
to Android development. By following the principles of dependency injection, you
lay the groundwork for a good app architecture.

Implementing dependency injection provides you with the following advantages:
* Reusability of code.
* Ease of refactoring.
* Ease of testing.


# Pre-requisites
* Experience with Kotlin syntax.
* You understand Dependency Injection.

# Getting Started
1. Install Android Studio, if you don't already have it.
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.


# Comparison between different branches
* [Full codelab comparison](https://github.com/googlecodelabs/android-hilt/compare/main...solution)


# License

```
Copyright (C) 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```