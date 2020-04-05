plugins {
    id(BuildPlugins.dynamicFeature)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
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
    viewBinding {
        isEnabled = true
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":app"))
    implementation(project(":core"))
    implementation(Libraries.constraintLayout)
    implementation(Libraries.coil)
    implementation(Libraries.shapedImageView)
    testImplementation(TestLibraries.junit4)

    // Koin
    implementation (Libraries.koinAndroid)
    implementation (Libraries.koinExt)
    implementation (Libraries.koinScope)
    implementation (Libraries.koinViewModel)

    //Test
    testImplementation(project(":test-utils", "testDependencies"))
}
