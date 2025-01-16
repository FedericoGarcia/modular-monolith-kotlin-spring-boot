plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.spring.boot)

    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.ApplicationKt"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
