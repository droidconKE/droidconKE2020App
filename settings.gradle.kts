pluginManagement {
    repositories {
        jcenter()
        google()
        gradlePluginPortal()
    }

    plugins {
        id("io.gitlab.arturbosch.detekt") version "1.14.2"
        id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
        id("androidx.navigation.safeargs.kotlin") version "2.3.1"
        id("com.android.application") version "4.1.0"
        id("org.jetbrains.kotlin.android") version "1.4.10"
        id("org.jetbrains.kotlin.android.extensions") version "1.4.10"
        id("com.android.dynamic-feature") version "4.1.0"
        id("com.android.library") version "4.1.0"
        id("com.google.firebase.crashlytics") version "2.3.0"
        id("com.google.gms.google-services") version "4.3.1"
        id("com.github.ben-manes.versions") version "0.36.0"
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library",
                "com.android.dynamic-feature" -> useModule("com.android.tools.build:gradle:4.1.0")
                "androidx.navigation.safeargs.kotlin" -> useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.1")
                "com.google.firebase.crashlytics" -> useModule("com.google.firebase:firebase-crashlytics-gradle:2.3.0")
                "com.google.gms.google-services" -> useModule("com.google.gms:google-services:4.3.4")
            }
        }
    }
}
include(
    ":core",
    ":repository",
    ":network",
    ":data",
    ":app",
    ":test-utils",
    ":features:feedback",
    ":features:speakers",
    ":features:auth",
    ":features:sessions",
    ":features:about",
    ":features:feed",
    ":features:home"
)