import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
plugins {
    kotlin("multiplatform") version "1.5.21"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build321"
    id("io.gitlab.arturbosch.detekt") version "1.18.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}

group = "org.chiachat.website"
version = "1.0"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0")
}

allprojects {

}

// Enable JS(IR) target and add dependencies
kotlin {
    js(IR) {
        browser{
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-core:1.6.2")
                implementation("io.ktor:ktor-client-js:1.6.2")
            }
        }
    }
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    debug.set(true)
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = true // activate all available (even unstable) rules.
    // point to your custom config defining rules to run, overwriting default behavior
    config = files("../config/detekt.yml")
    // a way of suppressing issues before introducing detekt
    baseline = file("../config/baseline.xml")

    reports {
        html.enabled = true // observe findings in your browser with structure and code snippets
        xml.enabled = true // checkstyle like format mainly for integrations like Jenkins
        txt.enabled = true
        // similar to the console output, contains issue signature to manually edit baseline files
        sarif.enabled = true
        // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    // Target version of the generated JVM bytecode. It is used for type resolution.
    jvmTarget = "1.8"
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().versions.webpackDevServer.version = "4.0.0-rc.0"
}
