import java.io.FileInputStream
import java.util.*

plugins {
    id(BuildPlugins.dynamicFeature)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.ktlintPlugin)
}
android {
    compileSdkVersion(AndroidSDK.compile)
    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    val localProperties = Properties()
    localProperties.load(FileInputStream(rootProject.file("local.properties")))

    buildTypes {
        val clientId = localProperties.getProperty("clientId", "Missing client id")
        val clientSecret = localProperties.getProperty("clientSecret", "Missing client secret")
        this.forEach {
            it.resValue("string", "server_client_id", clientId)
            it.resValue("string", "server_client_secret", clientSecret)
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":app"))
    implementation(project(BuildModules.Libraries.Repository))
    testImplementation(TestLibraries.junit4)

    // Koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)

//    androidTestImplementation(project(":test-utils"))

    // Google auth
    implementation(Libraries.googleButton)
    implementation(Libraries.coroutinePlayServices)
}

configurations.all {
    resolutionStrategy {
        force("org.objenesis:objenesis:2.6")
    }
}