group = "de.learn.kotlin"
version = "1.0-SNAPSHOT"

val ktlint by configurations.creating

plugins {
    id("java")
    kotlin("jvm") version "1.3.72"
}

repositories {
    mavenCentral()
}

var junitVersion = "5.3.2"

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    ktlint("com.pinterest:ktlint:0.37.2")
    testCompile(group = "org.junit.jupiter", name = "junit-jupiter-api", version = junitVersion)
    testCompile(group = "org.junit.jupiter", name = "junit-jupiter-params", version = junitVersion)
    testCompile(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = junitVersion)
}

val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Check Kotlin code style."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args = listOf("src/**/*.kt", "**/*.kts")
}

val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    main = "com.pinterest.ktlint.Main"
    args = listOf("-F", "src/**/*.kt", "**/*.kts")
}
