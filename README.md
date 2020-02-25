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
- Schedule
- Feed
- About

To learn how it was buit, we put this series together:

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

### Architecture

MVVM?

We will be using libraries, modules and dynamic feature modules too.

#### Modules
1. app -
2. base/core - library
3. data - for network requests
4. features - represent app specific features for  example schedule, 

=======
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

**Coding Convention**

For any view id, ie. Buttons, Edit Texts etc., we will use camelCase ie. btnLogin, etName.

Classes name end with the name of the component e.g. MainActivity and MainViewModel

For layout xml files the name of the component comes first i.e. fragment_login

The parent layout container id is given a prefix layout_ e.g. layout_login

Value files should always be in plural ie. strings/colors/styles etc.

String values should be named as txt_login or err_failed and should not be in block and colors values should be in small ie. colorBlue

Recycler view layouts should start with the prefix item eg. item_sessions

and xml attributes ie. background should be named as btn_login_bg.xml

Menu items should be named as activity_main it is repetitive to add the term menu since they are contained in the menu directory 

Ideally, in the xml, the first attribute after the tag is id, then width, then height and then anything else android: followed by app and lastly tools:


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
