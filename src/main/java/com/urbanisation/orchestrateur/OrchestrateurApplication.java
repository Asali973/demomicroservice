package com.urbanisation.orchestrateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.urbanisation.orchestrateur")// active recherche client feigh
@SpringBootApplication
public class OrchestrateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrateurApplication.class, args);
	}

}
