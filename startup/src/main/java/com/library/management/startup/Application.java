package com.library.management.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.library.management.startup",
        "com.library.management.repository",
        "com.library.management.domain",
        "com.library.management.service",
        "com.library.management.endpoints",
        "com.library.management.common"
})
@EnableJpaRepositories(basePackages = "com.library.management.repository")
@EntityScan(basePackages = "com.library.management.domain")  // For Book entity
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
