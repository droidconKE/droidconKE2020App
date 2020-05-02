object Versions {
    const val name = "1.0"
    const val code = 1
    const val kotlin = "1.3.61"
    const val coroutines = "1.3.3"
    const val buildToolsVersion = "3.6.0"

    const val jetPack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.1.0"
    const val material = "1.1.0-rc02"
    const val fragments = "1.2.3"
    const val androidAnimation = "0.2.0"
    const val shapedImageView = "0.8.7"
    const val coil = "0.9.5"
    const val koin = "2.1.4"
    const val room = "2.2.4"
    const val retrofit = "2.7.2"
    const val interceptor = "4.2.2"
    const val okHttp = "4.4.0"
    const val googleAuth = "17.0.0"
    const val googleServices = "9.2.1"

    const val junit4 = "4.12"
    const val testRunner = "1.1.1"
    const val rules = "1.1.1"
    const val espresso = "3.2.0"

    const val annotation = "1.1.0"
    const val mockk = "1.9"
    const val safeArgsPlugin = "2.2.1"
    const val archCore = "2.1.0"
    const val core = "1.2.0"
    const val fragmentsTesting = "1.2.3"
    const val kakao = "2.3.0"
    const val flexBox = "2.0.1"
    const val browser = "1.2.0"
    const val fakeit = "1.0.2"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
    const val kotlinKapt = "kotlin-kapt"
    const val safeArgs = "androidx.navigation.safeargs"
    const val safeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgsPlugin}"
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
    const val googleServices = "com.google.android.gms:play-services:${Versions.googleServices}"

    // Layouts
    const val flexBox = "com.google.android:flexbox:${Versions.flexBox}"

    // Browser
    const val browser = "androidx.browser:browser:${Versions.browser}"

    // Fake Data
    const val fakeit = "com.github.javafaker:javafaker:${Versions.fakeit}"
}

object APIs {
    private const val navVersion = "2.3.0-alpha01"
    const val ktxCore = "androidx.core:core-ktx:1.2.0"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${navVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navVersion"
    const val navigationDynamicFeature =
        "androidx.navigation:navigation-dynamic-features-fragment:$navVersion"
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