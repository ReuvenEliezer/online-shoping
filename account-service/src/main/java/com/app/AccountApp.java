package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@ComponentScan(basePackages = {
        "com.controllers",
        "com.config",
        "com.services",
})
@EnableJpaRepositories(basePackages = {"com.repositories"})
@EntityScan("com.entities")
@SpringBootApplication
public class AccountApp {

    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class, args);
    }

}
