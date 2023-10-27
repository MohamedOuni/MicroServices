package com.example.gestion_taches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
public class GestionTachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTachesApplication.class, args);
	}

}
