rootProject.name = "spring-boot-base-service"

include("api")
include("core")
include("infra")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}
