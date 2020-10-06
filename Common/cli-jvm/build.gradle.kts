plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "com.github.kchess"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(project(":algorithm-chinesechess"))
    compile(project(":algorithm-gobang"))
    compile(kotlin("stdlib-common"))
    compile(kotlin("stdlib-jdk8"))

    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
