plugins {
    id(BuildPlugins.dynamicFeature)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kapt)
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

    dataBinding {
        isEnabled
    }
    viewBinding {
        isEnabled
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":app"))
    testImplementation(TestLibraries.junit4)
    implementation(Libraries.shapedImageView)

    // Koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinExt)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)

    // Test
//    testImplementation(TestLibraries.junit4)
//    testImplementation(project(":test-utils"))
    testImplementation(project(":app", "testDependencies"))
//    androidTestImplementation(project(":test-utils"))
}

configurations.all {
    resolutionStrategy {
        force("org.objenesis:objenesis:2.6")
    }
}