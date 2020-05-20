pluginManagement {
    repositories {
        jcenter()
        google()
        gradlePluginPortal()
    }

    plugins {
        id(BuildPlugins.dektPlugin) version Versions.dekt
        id(BuildPlugins.ktlintPlugin) version Versions.ktlint
        id(BuildPlugins.safeArgs) version Versions.navVersion
        id(BuildPlugins.gradleVersionsPlugin) version Versions.gradleVersionsPlugin
        id(BuildPlugins.androidApplication) version Versions.buildToolsVersion
        id(BuildPlugins.kotlinAndroid) version Versions.kotlin
        id(BuildPlugins.kotlinAndroidExtensions) version Versions.kotlin
        id(BuildPlugins.dynamicFeature) version Versions.buildToolsVersion
        id(BuildPlugins.androidLibrary) version Versions.buildToolsVersion
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                BuildPlugins.androidApplication, BuildPlugins.androidLibrary,
                BuildPlugins.dynamicFeature -> useModule(BuildPlugins.androidGradlePlugin)
                BuildPlugins.safeArgs -> useModule(BuildPlugins.safeArgsGradlePlugin)
            }
        }
    }
}
include(
    BuildModules.Libraries.Core,
    BuildModules.Libraries.Repository,
    BuildModules.Libraries.Network,
    BuildModules.Libraries.Data,
    BuildModules.Libraries.App,
    BuildModules.Libraries.Test,
    BuildModules.Features.Feedback,
    BuildModules.Features.Speakers,
    BuildModules.Features.Auth,
    BuildModules.Features.Sessions,
    BuildModules.Features.About,
    BuildModules.Features.Feed,
    BuildModules.Features.Home
)
rootProject.name = "droidconKE2020"