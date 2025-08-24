buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

// Repositories are defined in settings.gradle.kts

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}