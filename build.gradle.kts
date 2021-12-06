plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    id("org.jetbrains.kotlin.kapt") version "1.6.0"
}

version = "{{inputs.project_version}}"
group = "{{inputs.project_group_id}}"

repositories {
    mavenCentral()
}

dependencies {
    val cdkVersion: String by project
    implementation("software.amazon.awscdk:core:$cdkVersion")
    implementation("software.amazon.awscdk:eks:$cdkVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.junit-pioneer:junit-pioneer:1.5.0")
    testImplementation("software.amazon.awscdk:assertions:$cdkVersion")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("{{inputs.project_group_id}}.{{inputs.project_name|title|replace(' ', '')}}Stack")
}