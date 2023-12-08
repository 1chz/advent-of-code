plugins {
    id("java")
    id("com.diffplug.spotless") version "6.22.0"
}

group = "io.shirohoo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat()
        indentWithSpaces()
        formatAnnotations()
        removeUnusedImports()
        trimTrailingWhitespace()
        importOrder("java", "jakarta", "org", "com", "net", "io")
    }

    kotlin {
        ktlint()
        indentWithSpaces()
        trimTrailingWhitespace()
    }

    kotlinGradle {
        ktlint()
        indentWithSpaces()
        trimTrailingWhitespace()
    }
}
