// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
        maven("https://maven.appspector.com/artifactory/android-sdk")

    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.6.0-alpha05")
        classpath(kotlin("gradle-plugin", version = "1.3.41"))
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.0-alpha01")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("com.appspector:android-sdk-plugin:1.+")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven("https://maven.appspector.com/artifactory/android-sdk")
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}