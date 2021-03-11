package com.uem.restcoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringRestCocheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestCocheApplication.class, args);
	}

}
