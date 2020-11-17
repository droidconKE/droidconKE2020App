object Versions {
    const val name = "1.0.1"
    const val code = 3
    const val kotlin = "1.4.10"
    const val coroutines = "1.4.1"
    const val buildToolsVersion = "4.1.0"

    const val jetPack = "1.3.0-alpha02"
    const val constraintLayout = "2.0.4"
    const val ktx = "1.5.0-alpha04"
    const val material = "1.3.0-alpha03"
    const val fragments = "1.3.0-beta01"
    const val androidAnimation = "0.2.0"
    const val shapedImageView = "0.9.0"
    const val coil = "1.0.0"
    const val koin = "2.2.0-rc-4"
    const val room = "2.3.0-alpha03"
    const val retrofit = "2.9.0"
    const val interceptor = "4.10.0-RC1"
    const val okHttp = "4.10.0-RC1"
    const val googleAuth = "19.0.0"
    const val googeButton = "1.1.0"
    const val googlePlayServices = "17.0.0"
    const val coroutinePlayServices = "1.3.9"

    const val junit4 = "4.13.1"
    const val testRunner = "1.1.0"
    const val rules = "1.1.0"
    const val espresso = "3.3.0"

    const val annotation = "1.2.0-alpha01"
    const val mockk = "1.10.2"
    const val safeArgsPlugin = "2.2.1"
    const val archCore = "2.1.0"
    const val core = "1.3.1-alpha02"
    const val fragmentsTesting = "1.3.0-beta01"
    const val kakao = "2.4.0"
    const val flexBox = "2.0.1"
    const val browser = "1.3.0-beta01"
    const val ktlint = "9.4.1"
    const val dekt = "1.14.2"
    const val navVersion = "2.3.1"
    const val fakeit = "1.0.2"
    const val gradleVersionsPlugin = "0.36.0"
    const val firebasePlugin = "2.1.0"
    const val firebaseAnalytics = "18.0.0"
    const val firebaseCrashlytics = "17.2.2"
    const val googleServices = "4.3.1"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinAndroidExtensions = "org.jetbrains.kotlin.android.extensions"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
    const val kotlinKapt = "kotlin-kapt"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val safeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
    const val kapt = "kotlin-kapt"
    const val ktlintGradlePlugin = "org.jlleitschuh.gradle:ktlint-gradle"
    const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
    const val dektPlugin = "io.gitlab.arturbosch.detekt"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val firebaseGradlePlugin =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebasePlugin}"
    const val firebasePlugin = "com.google.firebase.crashlytics"
    const val googleServices = "com.google.gms.google-services"
    const val googleServicesGradlePlugin = "com.google.gms:google-services:${Versions.googleServices}"
}

object Libraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutinesLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroidLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetPack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
    const val androidAnimation = "com.github.jama5262:AndroidAnimation:${Versions.androidAnimation}"
    const val shapedImageView = "cn.gavinliu:ShapedImageView:${Versions.shapedImageView}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val koinExt = "org.koin:koin-android-ext:${Versions.koin}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"

    // networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"

    //Auth
    const val googleAuth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"
    const val googleButton = "com.shobhitpuri.custombuttons:google-signin:${Versions.googeButton}"
    const val googlePlayServices =
        "com.google.android.gms:play-services-plus:${Versions.googlePlayServices}"
    const val coroutinePlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinePlayServices}"

    // Layouts
    const val flexBox = "com.google.android:flexbox:${Versions.flexBox}"

    // Browser
    const val browser = "androidx.browser:browser:${Versions.browser}"

    // Fake Data
    const val fakeit = "com.github.javafaker:javafaker:${Versions.fakeit}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"
    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
}

object APIs {
    const val ktxCore = "androidx.core:core-ktx:1.2.0"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val navigationDynamicFeature =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"
    const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragments}"
}

object AndroidSDK {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test.ext:junit:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.rules}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val archCore = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val core = "androidx.test:core:${Versions.core}"
    const val koin = "org.koin:koin-test:${Versions.koin}"
    const val fragment = "androidx.fragment:fragment-testing:${Versions.fragmentsTesting}"
    const val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
    const val mockServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
}

object BuildModules {
    object Features {
        const val Home = ":features:home"
        const val Feed = ":features:feed"
        const val Sessions = ":features:sessions"
        const val Auth = ":features:auth"
        const val Speakers = ":features:speakers"
        const val Feedback = ":features:feedback"
        const val About = ":features:about"
    }

    object Libraries {
        const val Core = ":core"
        const val Repository = ":repository"
        const val Network = ":network"
        const val Data = ":data"
        const val App = ":app"
        const val Test = ":test-utils"
    }
}