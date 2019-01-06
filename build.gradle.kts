group = "de.learn.kotlin"
version = "1.0-SNAPSHOT"

plugins{
    id("java")
    kotlin("jvm") version "1.3.11"
}

repositories{
    mavenCentral()
}

var junitVersion = "5.3.2"

dependencies{
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    testCompile(group="org.junit.jupiter", name = "junit-jupiter-api",version=junitVersion )
    testCompile(group="org.junit.jupiter", name = "junit-jupiter-params",version=junitVersion )
    testCompile(group="org.junit.jupiter", name = "junit-jupiter-engine",version=junitVersion )
}
