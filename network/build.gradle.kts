import java.io.FileInputStream
import java.util.*

plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.ktlintPlugin)
}

android {
    compileSdkVersion(AndroidSDK.compile)
    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    val localProperties = Properties()
    localProperties.load(FileInputStream(rootProject.file("local.properties")))

    buildTypes {
        val apiKey = localProperties.getProperty("apiKey", "Missing api key")
        this.forEach {
            it.buildConfigField("String", "API_KEY", "\"${apiKey}\"")
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.coroutinesLibrary)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(project(BuildModules.Libraries.Core))
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockServer)
    testImplementation(TestLibraries.koin)
    testImplementation(TestLibraries.coroutines)
    testImplementation(TestLibraries.mockk)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    // Retrofit
    api(Libraries.retrofit)
    implementation(Libraries.gsonConverter)
    implementation(Libraries.loggingInterceptor)

    // Koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)
}