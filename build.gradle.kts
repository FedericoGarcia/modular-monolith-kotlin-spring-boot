plugins {
    alias(libs.plugins.kotlin.jvm)

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

tasks.withType(Jar::class) {
    manifest {
        attributes["Main-Class"] = application.mainClass
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
