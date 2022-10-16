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
    kotlin("jvm") version "1.6.21"
    id("io.github.ermadmi78.kobby") version "2.0.0"
}

kobby {
    kotlin {
        scalars = mapOf(
            "Base64String" to typeString,
            "Date" to typeOf("java.time", "LocalDate"),
            "DateTime" to typeOf("java.time", "OffsetDateTime"),
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


dependencies {
    // Add this dependency to enable Jackson annotation generation in DTO classes by Kobby
    compileOnly("com.fasterxml.jackson.core:jackson-annotations:2.13.4")

    // Add this dependency to enable default Ktor adapters generation
    compileOnly("io.ktor:ktor-client-cio:2.1.2")
}
