package com.projet_spring.ensa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringApplication.class, args);
    }

}
