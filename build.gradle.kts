import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.rak.manapart"
version = ""

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")

}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.rak.manapart:quest-command:dev") {
//    implementation("org.rak.manapart:quest-command:0.0.6") {
        exclude("org.jetbrains.kotlin","kotlin-stdlib")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

}