plugins {
    kotlin("multiplatform") version "1.3.72"
}

group = "com.github.kchess"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        nodejs()
    }
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api(project(":algorithm"))
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
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
                implementation(npm("jest"))
            }
        }
    }
}

tasks {
    create("publishNpm") {
        group = "publish"
        dependsOn(rootProject.tasks.getByName("clean"))
        dependsOn(getByName("assemble"))
        doLast {
            file("$rootDir/build/js/packages").listFiles()
                .forEach { path ->
                    if (!path.name.contains("test")) {
                        project.exec {
                            println("npm publish $path")
                            commandLine("npm", "publish", path)
                        }
                    }
                }
        }
    }
}
