plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.ktlintPlugin)
}

android {
    compileSdkVersion(AndroidSDK.compile)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)

    api(TestLibraries.junit4)
    api(TestLibraries.mockk)
    api(TestLibraries.archCore)
    api(TestLibraries.core)
    api(TestLibraries.koin)
    api(TestLibraries.testRules)
    api(TestLibraries.kakao)
    api(TestLibraries.testRunner)
    api(TestLibraries.espresso)
    api(TestLibraries.annotation)
}

configurations.all {
    resolutionStrategy {
        force("org.objenesis:objenesis:2.6")
    }
}