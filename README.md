<p align="center">
  <a href="https://github.com/droidconKE/droidconKE2020App">
    <img src="https://raw.githubusercontent.com/droidconKE/iconPack/master/androidIcon/android-icon-144x144.png" alt="droidconKE2020">
  </a>
  <h3 align="center">droidcon2020 Conference App</h3>
  <p align="center">
    The official  <a href="https://droidcon.co.ke/">DroidconKE 2020 conference App</a>.
    <br>
    <img src="https://forthebadge.com/images/badges/built-for-android.svg" alt="droidconKE2020 built for Android">
    <br>
    </p>
</p>

### Table of contents

**1 [About the App](#about-the-app)**<br>
**2 [General Preview](#general-preview)**<br>
**3 [Technical](#technical)**<br>
**4 [Work in Progress](#work-in-progress)**<br>
**5 [Contributing](#contributing)**<br>
**6 [License](#license)**<br>
**7 [Versions](#versions)**<br>
**8 [Contributers](#contributers)**<br>

:point_down: :point_down: :point_down: :point_down: :point_down:


## About the App
Android app for the 3rd Android Developer conference- droidcon to be held in Nairobi from Auguts 6-8th 2020.

This project is the Android app for the conference. The app supports devices running Android 5.0+, and is optimized for phones and tablets of all shapes and sizes.
The source reflects teh app as at droidconKE 2020!

### Features
=======
### droidconKE 2020 Android App

Android app for the third Android Developer conference-droidcon in Nairobi 2020

This project is the Android app for the conference. The app supports devices running Android 5.0+, and is optimized for phones and tablets of all shapes and sizes.

### Source

The source code in this repository reflects the app as of droidconKE 2020.

### Features

App will have the following features:
- Sessions
- Feed
- About
- Home
- Speakers
- Auth
- Feedback

To learn how it was built, we put this series together:

[(NOT YET OUT) - Coming soon! Building the droidconKE 2020 App](https://hashnode.com/series/building-the-droidconke-2020-app-ck6970eby04oakbs19u8bbru2)

Like, share claps... :wink:

## General Preview
#### Screenshots
Coming soon!
<img src="#" width="30%"><img src="#" width="30%"><img src="#" width="30%">


### Demo

a You can give it a spin [here on appetize](#)

b.Compile the project on android studio and run it.

c. download it from the playstore:

[![Download it on Google Play](https://raw.githubusercontent.com/tamzi/ReadMe-MasterTemplates/master/android/images/gplay.png)](#)


## Technical

### Running the project
**1. Required to run project:**
check **"dependencies"** below

 - Use Android studio 3.4 and later. It will be less messy.

**2. Clone this repository:**

    `git clone https://github.com/droidconKE/droidconKE2020App.git`

**3. open Project in Android Studio**

**4. Build Project**

**5. Incase of an error when building project, update your gradle version, Build Tools download**


=======
### Development Environment
The app is written fully in Kotlin and uses the Gradle build system.

To build the app, use the gradlew build command or use "Import Project" in Android Studio. A canary or stable version >= 3.4 of Android Studio is required and may be downloaded [here](https://developer.android.com/studio/archive).

### Architecture

Proposed Architecture:

We will be using libraries, modules and dynamic feature modules too.

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

#### Modules To Be There:
With the above in mind, here are the actual modules in the droidconKE2020 app following the guidelines laid above
1. app 
2. core (library)
3. data (library)
4. features - directory for grouping all the feature modules together. It has the following dynamic feature modules:

    - about - has the details of the event,  team members and their details that is when each team member card is clicked
    - auth - has the signup,signin, forgot password and reset password logic
    - feed - has a #droidconKE newsfeed
    - feedback - has session and event feedback logic
    - home - shows sponsors,promoted stuff,organizers and changes according to time ie before and during the event
    - sessions - shows each days sessions(day one,day two, day three) session details, and also has filter sessions logic and show a user's favorited sessions
    - speaker  - shows speaker details
 5. repository(library)
 6. network(library)
 
 
 #### Navigation
 The app uses Single Activity Architecture. And follows [Navigation Principles](https://developer.android.com/guide/navigation/navigation-principles) from Jetpack. And since features are all dynamic modules, we have taken advantage of the introduction of the support of dynamic features in the navigation component in the latest [release](https://developer.android.com/jetpack/androidx/releases/navigation#2.3.0-alpha01). How this works is we use fragments in the feature modules and add the fragments to the main nav graph which has the support for adding destinations from dynamic feature modules. More on this is in the [Navigate with dynamic feature modules
](https://developer.android.com/guide/navigation/navigation-dynamic) tutorial. Note: Adding destinations might not work in AS version below 3.6 Release Candidate 3(RC3) and destination fragment name might be in red but no worries, app runs well as expected.


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
	- [Ktlint](https://ktlint.github.io/)

### Feature Modules:

Each module have its own domain,data,and presentation or how do we approach this

#### Permissions
 TBA

### References/Resources
1.  [Android ShowCase](https://github.com/igorwojda/android-showcase)
2.  [Kotlin Sample App](https://github.com/VMadalin/kotlin-sample-app)
3.  [DroidKaigi Conference App 2020](https://github.com/DroidKaigi/conference-app-2020)
4.  [Clean Architecture post on ProAndroid Dev](https://proandroiddev.com/multiple-ways-of-defining-clean-architecture-layers-bbb70afa5d4a)
5.  [ReadME Master templates](https://github.com/tamzi/ReadMe-MasterTemplates)
6.  [contributors-img](https://contributors-img.firebaseapp.com)
## Work in progress

:construction: ⛏ 🔧️ :construction:
=======
	- Ktlint [https://ktlint.github.io/]

On Feature Modules: Does each module have its own domain,data,and presentation or how do we approach this

###  \[ 🚧 Work in progress 👷‍♀️⛏👷🔧️ 🚧 \]

- [ ] Finalize on the final App architecture.
- [ ] Setup app modules
- [ ] Work on Modules Specifics
- [ ] Dependencies Setup - Gradle kts

You can improve on this and add further features:

- [Your suggestion as an issue here](https://github.com/droidconKE/droidconKE2020App/issues)



## Contributing

We would love to have your help in making  **droidconKE 2020 App** better.
The project is still very incomplete, but if there's an issue you'd like to see addressed sooner rather than later, let us know.

Before you contribute though read the contributing guide here: [CONTRIBUTING GUIDE](https://github.com/tamzi/droidconKE2020App/blob/master/contributing.md)

For any concerns kindly:
- [Open an issue](https://github.com/droidconKE/droidconKE2020App/issues),

    or JUST,

- [Fork the project and send a pull request](https://github.com/droidconKE/droidconKE2020App/pulls).



## License

### Assets

**Credits:**
- Logo is used from [droidconKE](https://droidcon.co.ke/)

- Follow them twitter: [@droidconKE](https://twitter.com/droidconke?lang=en)



[![license](https://img.shields.io/github/license/mashape/apistatus.svg?style=for-the-badge)](#)

[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source-200x33.png?v=103)](#)





## Versions

Version 1.0   TBR (To Be Released)


## Contributers
Auto-populated from:
[contributors-img](https://contributors-img.firebaseapp.com/image?repo=droidconke/droidconKE2020App)

<a href="https://github.com/droidconke/droidconKE2020App/graphs/contributors">
  <img src="https://contributors-img.firebaseapp.com/image?repo=droidconke/droidconKE2020App" />
</a>


:bowtie: :v: :tropical_drink:
=======
### References/Resources
1.  https://github.com/igorwojda/android-showcase
2.  https://github.com/VMadalin/kotlin-sample-app
3.  https://github.com/DroidKaigi/conference-app-2020
4.  https://proandroiddev.com/multiple-ways-of-defining-clean-architecture-layers-bbb70afa5d4a
