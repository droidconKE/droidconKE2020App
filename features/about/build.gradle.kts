plugins {
    id(BuildPlugins.dynamicFeature)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.kotlinKapt)
}
android {
    compileSdkVersion(AndroidSDK.compile)

    defaultConfig {
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)

        testInstrumentationRunner = "com.android254.droidconKE2020.test_utils.KoinRunner"
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
    implementation(project(":app"))
    implementation(project(":core"))

    debugImplementation(project(":app", "debugDependencies"))

    // Testing Libraries
    testImplementation(project(":app", "testDependencies"))
    androidTestImplementation(project(":app", "intTestDependencies"))
}

configurations.all {
    resolutionStrategy {
        force("org.objenesis:objenesis:2.6")
    }
}