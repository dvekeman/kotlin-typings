plugins {
    java
    war
    kotlin("jvm") version "1.3.31"

}

repositories {
    jcenter()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compile("javax:javaee-api:7.0")
    implementation(kotlin("stdlib"))
}
