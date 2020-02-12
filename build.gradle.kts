// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    //ext.kotlin_version = '1.3.61'
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register("clean").configure{
    delete("build")
}