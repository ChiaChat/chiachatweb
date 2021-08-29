import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "org.chiachat"
version = "1.0"

// Enable JS(IR) target and add dependencies
kotlin {
    js(IR) {
        browser { }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                api(project(":common"))
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-core:1.6.2")
                implementation("io.ktor:ktor-client-js:1.6.2")
                implementation("app.softwork:routing-compose:0.0.27")
            }
        }
    }
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<NodeJsRootExtension>().versions.webpackDevServer.version = "4.0.0-rc.0"
}
