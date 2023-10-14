package com.example.EquipeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EquipeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipeServiceApplication.class, args);
	}

}
