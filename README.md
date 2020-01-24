### droidconKE 2020 Android App

Android app for the third Android Developer conference-droidcon in Nairobi 2020

This project is the Android app for the conference. The app supports devices running Android 5.0+, and is optimized for phones and tablets of all shapes and sizes.

### Source

The source code in this repository reflects the app as of droidconKE 2020.

### Features

App will have the following features:
- Schedule
- Feed
- About


### Development Environment
The app is written fully in Kotlin and uses the Gradle build system.

To build the app, use the gradlew build command or use "Import Project" in Android Studio. A canary or stable version >= 3.4 of Android Studio is required and may be downloaded [here](https://developer.android.com/studio/archive).

### Architecture

#### Modularizing .droidconKE

Proposed Architecture:

We will be using libraries, modules and dynamic feature modules too.

#### Modules To Be There:
1. app -
2. base/core - library
3. data - for network requests
4. features - represent app specific features for  example schedule, 

#### Dynamic Feature Modules
1. Ticket - attendees can buy  tickets
2

#### Dependencies
1. Jetpack - Jetpack Libraries to use
	- LiveData
	- AndroidX
	- Android KTX
	- Navigation
	- Room
	- ViewModel
	- Lifecycle
2. Coroutines - For Concurrency and Asynchronous tasks
3. Retrofit - For network requests
4. Koin - For Dependency Injection
5. Crashlytics
6. Coil - For Image Loading and Caching
7. Firebase Perf - For analyzing app perfomance
8. Testing Dependencies -
	- JUnit
	- AndroidX Test
	- Espresso
	- Mockk
	- Roboelectric
	- Kakao
9. Lint Checks - Consider adding a library for lint checks
	- Ktlint [https://ktlint.github.io/]

On Feature Modules: Does each module have its own domain,data,and presentation or how do we approach this

###  \[ 🚧 Work in progress 👷‍♀️⛏👷🔧️ 🚧 \]

- [ ] Finalize on the final App architecture.
- [ ] Setup app modules
- [ ] Work on Modules Specifics
- [ ] Dependencies Setup - Gradle kts

### References/Resources
1.  https://github.com/igorwojda/android-showcase
2.  https://github.com/VMadalin/kotlin-sample-app
3.  https://github.com/DroidKaigi/conference-app-2020
4.  https://proandroiddev.com/multiple-ways-of-defining-clean-architecture-layers-bbb70afa5d4a
