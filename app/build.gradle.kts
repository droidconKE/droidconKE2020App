
import java.util.*

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.safeArgs)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.firebasePlugin)
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

//    val keystorePropertiesFile = rootProject.file("keystore.properties")
//    val keystoreProperties = Properties()
//    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
//
//    signingConfigs {
//        create("release") {
//            storeFile = file(keystoreProperties.getProperty("storeFile"))
//            keyAlias = keystoreProperties.getProperty("keyAlias")
//            keyPassword = keystoreProperties.getProperty("keyPassword")
//            storePassword = keystoreProperties.getProperty("storePassword")
//        }
//    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
//            signingConfig = signingConfigs.getByName("release")
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

    androidTestImplementation(TestLibraries.testRules)
    androidTestImplementation(TestLibraries.koin)
    debugImplementation(TestLibraries.fragment)
    androidTestImplementation(TestLibraries.kakao)
    implementation(Libraries.googlePlayServices)
    // Mock data
    api(Libraries.fakeit)
    api(Libraries.firebaseCrashlytics)
    api(Libraries.firebaseAnalytics)
}
apply(plugin = BuildPlugins.googleServices)