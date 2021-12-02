plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("maven-publish")
}

group = "ca.allanwang"

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

val pluginId = "ca.allanwang.gradle.test"

gradlePlugin {
    plugins.register(pluginId) {
        id = pluginId
        implementationClass = "ca.allanwang.playground.gradle.plugin.TestPlugin"
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly("com.android.tools.build:gradle:4.2.2")
}