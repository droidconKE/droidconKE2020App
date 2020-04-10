plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(AndroidSDK.compile)
    buildToolsVersion("29.0.2")

    defaultConfig {
        applicationId = "com.android254.droidconKE2020"
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

val testDependencies by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

dependencies {
    implementation(Libraries.appCompat)
    implementation(Libraries.materialComponents)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.archCore)
    testImplementation(TestLibraries.core)
    testImplementation(TestLibraries.koin)
}
