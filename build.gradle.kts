import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

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
    implementation(libs.guava)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.web)

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.wrapper {
    gradleVersion = "8.14"
    distributionType = Wrapper.DistributionType.BIN
}

tasks.bootRun {
  jvmArgs = listOf("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005")
}

tasks.test {
    val mockitoCoreJar = configurations.testRuntimeClasspath.get().find { it.name.contains("mockito-core") }!!
    jvmArgs = listOf(
        "-javaagent:${mockitoCoreJar.absolutePath}",
        "-Dorg.mockito.configuration.file=src/test/resources/mockito.properties"
    )
    useJUnitPlatform()
    testLogging {
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
        failFast = true
        events(
            TestLogEvent.PASSED,
            TestLogEvent.FAILED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR,
        )
    }
}
