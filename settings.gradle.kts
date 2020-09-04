
rootProject.name = "bom"

pluginManagement {
    // https://docs.gradle.org/current/userguide/plugins.html#sec:plugin_version_management
    val gmatePluginVersion: String by settings
    val kotlinJvmVersion: String by settings
    val shadowVersion: String by settings
    val lombokVersion: String by settings
    val springBootVersion: String by settings
    val springDepsVersion: String by settings

    plugins {
        id("io.github.sokrato.gmate") version gmatePluginVersion
        id("com.github.johnrengelman.shadow") version shadowVersion
        id("io.freefair.lombok")  version lombokVersion

        kotlin("jvm") version kotlinJvmVersion
        kotlin("plugin.spring") version kotlinJvmVersion
        kotlin("plugin.allopen") version kotlinJvmVersion

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDepsVersion
    }

    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}