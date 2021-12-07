plugins {
    application
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
}

version = "{{inputs.project_version}}"
group = "{{inputs.project_group_id}}"

repositories {
    mavenCentral()
}

dependencies {
    val cdkVersion: String by project
    implementation("software.amazon.awscdk:core:$cdkVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.junit-pioneer:junit-pioneer:1.5.0")
    testImplementation("software.amazon.awscdk:assertions:$cdkVersion")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain {
        val jdkVersion: String by project
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }
}

application {
    mainClass.set("{{inputs.project_group_id}}.{{computed_inputs.app_class_name}}Kt")
}