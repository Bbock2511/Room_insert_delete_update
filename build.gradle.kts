// Top-level build file where you can add configuration options common to all sub-projects/modules.


plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    kotlin("jvm") version "1.9.10" apply false
    //kotlin("android") version "1.4.20" apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.10"))
        val navVersion = "2.7.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}