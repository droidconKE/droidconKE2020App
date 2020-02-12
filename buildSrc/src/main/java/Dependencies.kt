object Versions {
    const val kotlin = "1.3.61"
    const val buildToolsVersion = "3.5.3"
    const val jetPack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.1.0"
    const val material = "1.0.0"

    const val junit4 = "4.12"
    const val testRunner = "1.1.1"
    const val espresso = "3.2.0"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object Libraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat        = "androidx.appcompat:appcompat:${Versions.jetPack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
}

object AndroidSDK{
    const val min = 21
    const val compile = 29
    const val target = compile
}

object TestLibraries {
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}