import io.github.ermadmi78.kobby.kobby

repositories {
    mavenLocal()
    mavenCentral()
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("io.github.ermadmi78.kobby") version "4.0.1"
}

kobby {
    kotlin {
        scalars = mapOf(
            "Base64String" to typeString,
            "Date" to typeOf("kotlinx.datetime", "LocalDate"),
            "DateTime" to typeOf("kotlinx.datetime", "LocalDateTime"),
            "GitObjectID" to typeString,
            "GitSSHRemote" to typeString,
            "GitTimestamp" to typeString,
            "HTML" to typeString,
            "PreciseDateTime" to typeString,
            "URI" to typeString,
            "X509Certificate" to typeString
        )
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // Add this dependency to enable Kotlinx Serialization
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0-RC")

    // Add this dependency to use datetime scalars with Kotlinx Serialization support
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")

    // Add this dependency to enable default Ktor adapters generation
    compileOnly("io.ktor:ktor-client-cio:2.3.11")
}
