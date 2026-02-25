plugins {
    id("java-library")
}

dependencies {

    api(project(":core"))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.kafka)
    implementation(libs.spring.boot.starter.liquibase)
    implementation(libs.aws.s3)

    runtimeOnly(libs.postgresql)

    testImplementation(rootProject.libs.spring.boot.starter.test)
}

