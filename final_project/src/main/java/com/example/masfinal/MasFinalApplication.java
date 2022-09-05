package com.example.masfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring application starter class
 */
@SpringBootApplication
@EnableJpaRepositories
public class MasFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasFinalApplication.class, args);
    }

}
