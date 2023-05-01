package com.example.trek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.h2")
public class FakerAttemptApplication {


    public static void main(String[] args) {
        SpringApplication.run(FakerAttemptApplication.class, args);
    }

}
