plugins {
    id("com.github.johnrengelman.shadow") version "8.0.0"
    kotlin("jvm") version "1.9.23"
}

group = "me.aquabtw"
version = "1"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}