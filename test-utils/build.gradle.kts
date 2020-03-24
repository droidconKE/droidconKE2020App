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

dependencies {
    implementation(Libraries.appCompat)
}
