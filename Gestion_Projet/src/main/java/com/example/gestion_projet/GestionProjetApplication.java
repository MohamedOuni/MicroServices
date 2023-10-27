package com.example.gestion_projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy // activation AOP
@EnableScheduling
public class GestionProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionProjetApplication.class, args);
    }

}
