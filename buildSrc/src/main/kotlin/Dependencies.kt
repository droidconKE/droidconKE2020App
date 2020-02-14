object Versions {
    const val name = "1.0"
    const val code = 1

    const val kotlin = "1.3.61"
    const val coroutines = "1.3.3"
    const val buildToolsVersion = "3.5.3"
    const val jetPack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.1.0"
    const val material = "1.0.0"

    const val junit4 = "4.12"
    const val testRunner = "1.1.1"
    const val espresso = "3.2.0"
    const val annotation = "1.1.0"
    const val mockk = "1.9"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
}

object Libraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutinesLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroidLibrary =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompat        = "androidx.appcompat:appcompat:${Versions.jetPack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
}

object APIs {
    private const val navVersion = "2.3.0-alpha01"
    const val ktxCore = "androidx.core:core-ktx:1.2.0"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${navVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navVersion"
    const val navigationDynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:$navVersion"
}

object AndroidSDK{
    const val min = 21
    const val compile = 29
    const val target = compile
}

object TestLibraries {
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object BuildModules{
    object Features {
        const val Home = ":features:home"
        const val Feed = ":features:feed"
        const val Sessions = ":features:sessions"
        const val Auth = ":features:auth"
        const val Speaker = ":features:speaker"
        const val Feedback = ":features:feedback"
        const val About = ":features:about"
    }
    object Libraries{
        const val Core = ":core"
        const val Repository = ":repository"
        const val Network = ":network"
        const val Data = ":data"
        const val App = ":app"
    }
}