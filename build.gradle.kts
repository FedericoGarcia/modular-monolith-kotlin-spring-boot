application {
    mainClass = "org.example.ApplicationKt"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.boot)

    application
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
