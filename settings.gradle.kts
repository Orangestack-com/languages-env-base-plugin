pluginManagement {
    val artifactoryUrl: String by settings

    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven {
            url = uri(artifactoryUrl)
        }
    }
}
rootProject.name = "{{inputs.project_name}}"