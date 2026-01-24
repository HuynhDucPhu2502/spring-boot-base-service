package com.fis.spring_boot_base_service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fis.spring_boot_base_service")
public class SpringBootBaseServiceApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringBootBaseServiceApplication.class, args);
  }
}
