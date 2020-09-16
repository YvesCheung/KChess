plugins {
//    id("org.jetbrains.kotlin.js") version "1.3.72"
//    kotlin("jvm") version "1.3.72"
    kotlin("multiplatform") version "1.3.72"
}

group = "com.github.kchess"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js()
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}
//kotlin.target.browser { }
//kotlin.target.nodejs { }
//tasks {
//    compileKotlin {
//        kotlinOptions.jvmTarget = "1.8"
//    }
//    compileTestKotlin {
//        kotlinOptions.jvmTarget = "1.8"
//    }
//}
