# Spring Boot Base Service

Base service theo kiến trúc multi-module, hướng đến Clean Architecture: tách lớp domain/use-case, lớp hạ tầng và lớp API. Mục tiêu là dễ mở rộng, dễ thay đổi hạ tầng, và giữ phần nghiệp vụ ổn định.

## Mục lục
- [Giới thiệu](#giới-thiệu)
- [Kiến trúc module](#kiến-trúc-module)
- [INSTRUCTION.md](#instructionmd)
- [Yêu cầu cài đặt](#yêu-cầu-cài-đặt)
- [Cài đặt và cấu hình DB](#cài-đặt-và-cấu-hình-db)
- [Build dự án](#build-dự-án)
- [Chạy ứng dụng](#chạy-ứng-dụng)
- [Build Docker image (Jib)](#build-docker-image-jib)
- [Cấu hình nhanh](#cấu-hình-nhanh)
- [Ghi chú](#ghi-chú)

## Giới thiệu
- Dự án dùng Spring Boot và cấu trúc multi-module để chia nhỏ trách nhiệm.
- Phù hợp làm template cho service mới: sẵn cấu hình logging, validation, security, JPA, Liquibase, OpenAPI.
- Dễ mở rộng thêm adapter (Kafka, S3, v.v.) trong module `infra`.

## Kiến trúc module
- `api`: REST API, security, cấu hình chạy ứng dụng.
- `core`: domain + use-case thuần, không phụ thuộc framework.
- `infra`: hạ tầng (JPA, Liquibase, Kafka, S3, v.v.), implement các adapter.

## INSTRUCTION.md
Tài liệu dành cho AI để tích hợp, chỉnh sửa hoặc mở rộng dự án: `INSTRUCTION.md`.

## Yêu cầu cài đặt
- JDK 25 (hoặc đúng version bạn đang dùng cho dự án).
- Gradle Wrapper (đã có sẵn trong repo).
- PostgreSQL 14+ (khuyến nghị).
- (Tuỳ chọn) Docker nếu muốn chạy DB bằng container.

## Cài đặt và cấu hình DB
1. Tạo database:
```sql
CREATE DATABASE "test-db";
```

2. Cập nhật cấu hình DB trong `api/src/main/resources/application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/test-db
    username: postgres
    password: root
```

3. Bật Liquibase (mặc định đã bật):
```yaml
spring:
  liquibase:
    enabled: true
    change-log: classpath:/db/changelog/db.changelog-master.yaml
```

## Build dự án
```bash
./gradlew build
```

## Chạy ứng dụng
```bash
./gradlew :api:bootRun
```

Hoặc chạy bằng IDE:
- Main class: `com.fis.spring_boot_base_service.SpringBootBaseServiceApplication`

## Build Docker image (Jib)
Jib đã được cấu hình trong module `api`.

1. Build image local (Docker daemon):
```bash
./gradlew :api:jibDockerBuild
```

2. Push image lên registry:
```bash
./gradlew :api:jib
```

3. Tên image mặc định:
```
your-org/spring-boot-base-service
```

Bạn có thể đổi image trong `api/build.gradle.kts`:
```
jib {
    to.image = "your-org/your-image"
}
```

## Cấu hình nhanh
Các cấu hình thường dùng nằm ở `api/src/main/resources/application.yaml`:
```yaml
server:
  port: 8080

spring:
  profiles:
    active: default
```

## Ghi chú
- Nếu không có DB, ứng dụng sẽ lỗi khi khởi động (Liquibase và DataSource yêu cầu kết nối).
- Cấu hình khác (port, profile, logging, v.v.) có thể thêm vào `api/src/main/resources/application.yaml`.
