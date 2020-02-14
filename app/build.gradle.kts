plugins{
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
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    dynamicFeatures = mutableSetOf(
        BuildModules.Features.Home,
        BuildModules.Features.Feed,
        BuildModules.Features.About,
        BuildModules.Features.Sessions,
        BuildModules.Features.Auth,
        BuildModules.Features.Speaker,
        BuildModules.Features.Feedback
    )
}

dependencies {
    api(APIs.ktxCore)
    api(APIs.kotlinStandardLibrary)
    api(APIs.navigationFragment)
    api(APIs.navigationUI)
    api(APIs.navigationDynamicFeature)
    implementation (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.appCompat)
    implementation (Libraries.ktxCore)
    implementation (Libraries.constraintLayout)
    implementation (Libraries.materialComponents)
    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
    androidTestImplementation (TestLibraries.annotation)
}