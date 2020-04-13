plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.safeArgs)
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    dynamicFeatures = mutableSetOf(
        BuildModules.Features.Home,
        BuildModules.Features.Feed,
        BuildModules.Features.About,
        BuildModules.Features.Sessions,
        BuildModules.Features.Auth,
        BuildModules.Features.Speakers,
        BuildModules.Features.Feedback
    )

    viewBinding {
        isEnabled = true
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

val intTestDependencies by configurations.creating {
    extendsFrom(configurations["androidTestImplementation"])
}

dependencies {
    implementation(project(BuildModules.Libraries.Data))
    api(project(BuildModules.Libraries.Core))
    implementation(project(BuildModules.Libraries.Network))
    implementation(project(BuildModules.Libraries.Repository))

    api(APIs.ktxCore)
    api(APIs.kotlinStandardLibrary)
    api(APIs.navigationFragment)
    api(APIs.navigationUI)
    api(APIs.navigationDynamicFeature)
    api(APIs.fragments)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    api(Libraries.constraintLayout)
    api(Libraries.materialComponents)
    implementation(Libraries.androidAnimation)
    api(Libraries.coil)
    api(Libraries.shapedImageView)
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.annotation)

    // Koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)

    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.testRules)
    androidTestImplementation(TestLibraries.koin)
    debugImplementation(TestLibraries.fragment)
    androidTestImplementation(TestLibraries.kakao)

    //Google services
    implementation(Libraries.googleServices)

    // Mock data
    api(Libraries.fakeit)
}
