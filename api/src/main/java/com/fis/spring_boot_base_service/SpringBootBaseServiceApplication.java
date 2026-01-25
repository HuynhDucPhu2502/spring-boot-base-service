package com.fis.spring_boot_base_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringBootBaseServiceApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringBootBaseServiceApplication.class, args);
  }
}
