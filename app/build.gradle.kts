import java.io.FileInputStream
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
    defaultConfig {
        applicationId = "com.android254.droidconKE2020"
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name
        setProperty("archivesBaseName", "DroidconKe2021")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val keystoreProperties = Properties()
    val keystorePropertiesFile = rootProject.file("keystore.properties")
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    signingConfigs {

        if (keystoreProperties.isNotEmpty()) {
            create("release") {
                storeFile = file(keystoreProperties.getProperty("storeFile"))
                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
                storePassword = keystoreProperties.getProperty("storePassword")
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            if (keystoreProperties.isNotEmpty()) {
                signingConfig = signingConfigs.getByName("release")
            }

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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

val debugDependencies by configurations.creating {
    extendsFrom(configurations["debugApi"])
}

val intTestDependencies by configurations.creating {
    extendsFrom(configurations["androidTestApi"])
}

val testDependencies by configurations.creating {
    extendsFrom(configurations["testApi"])
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
    api(Libraries.appCompat)
    api(Libraries.constraintLayout)
    api(Libraries.materialComponents)
    implementation(Libraries.androidAnimation)
    api(Libraries.coil)
    api(Libraries.shapedImageView)

    // Koin
    api(Libraries.koinAndroid)
    api(Libraries.koinExt)
    api(Libraries.koinScope)
    api(Libraries.koinViewModel)

    api(Libraries.googlePlayServices)
    api(Libraries.googleAuth)
    // Mock data
    api(Libraries.fakeit)
    api(Libraries.firebaseCrashlytics)
    api(Libraries.firebaseAnalytics)

    debugApi(TestLibraries.fragment)
    testApi(project(BuildModules.Libraries.Test))
    androidTestApi(project(BuildModules.Libraries.Test))
}
apply(plugin = BuildPlugins.googleServices)

configurations.all {
    resolutionStrategy {
        force("org.objenesis:objenesis:2.6")
    }
}