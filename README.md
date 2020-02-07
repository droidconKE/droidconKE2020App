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

### Architecture Introduction
We took a modularisation approach to develop the application. There are immense benefits that come about with modularising an application; faster builds due to gradle caching and parallelism, benefit of dynamic features which can be delivered on demand therefore reducing initial apk size, clear separation of concerns and ease of maintaining and adding new features. An application can be modularised either by feature or by layer, we decided to take a hybrid approach that combines both approaches. 

**Data Module**

The data module provides support for data persistence and offline caching. It consists of room database, entities and daos. We opted for a single database source of truth as opposed to having multiple databases for each feature. At the point of developing this application, Room did not support multi-database queries and thus having a single database will save us time trying to combine data from multiple databases. In addition to this, a single database helps us avoid duplication of data and tests. The data module exposes itself to the repository layer via a datasource interface to prevent the repository from knowing the implementation details of the data layer thus observing the dependency rule. This will also enhance the flexibility of the application as we can easily switch from Room to SQLite or Realm if need be. This module consists of a mapper to convert entities to data classes that can be passed around.

**Network Module**

The network module provides support for making network requests to external APIs. This module basically consists of retrofit interfaces, response data classes and mappers to convert the response classes. The network module is exposed to the repository layer via a remote datasource. 

**Repository module**

The repository module depends on the data module and the network module. The role of this module is to sync data from different sources and present it as a single source. Ideally, the repository module observes the repository pattern recommended by Google.

**Features**

The application contains three features i.e. schedule, feed & about and one dynamic feature i.e tickets. The features depend on the repository module and the core module. The dynamic feature depends on the app module.

**App**

The app module handles navigation between the features. It also consists of key UI activities or fragments. e.g. Login. 

**Base Core**

Consists of classes and logic that is to be shared across the application. It contains utility classes and functions as well. The base core is a library.

<p align="center">
  <img src="Droid Con Architectire.png" width="500" alt="App Architecture">
</p>


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
