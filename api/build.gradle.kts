plugins {
    id("application")
    id("java-library")

    id("com.google.cloud.tools.jib") version "3.5.2"
}

application {
    mainClass.set("com.fis.spring_boot_base_service.api.SpringBootBaseServiceApplication")
}

dependencies {

    implementation(project(":core"))
    runtimeOnly(project(":infra"))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.actuator)

    implementation(libs.openapi.doc)

    annotationProcessor(libs.spring.boot.configuration.processor)

    testImplementation(libs.spring.boot.starter.webmvc.test)
    testImplementation(libs.spring.security.test)

}

jib {
    to.image = "your-org/spring-boot-base-service"
}
