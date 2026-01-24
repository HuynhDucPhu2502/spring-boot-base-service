plugins {
    id("java-library")
}

dependencies {

    api(project(":common"))

    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.kafka)

    runtimeOnly(libs.postgresql)

    testImplementation(rootProject.libs.spring.boot.starter.test)
}

