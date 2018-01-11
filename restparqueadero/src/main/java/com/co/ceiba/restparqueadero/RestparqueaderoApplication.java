package com.co.ceiba.restparqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestparqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestparqueaderoApplication.class, args);
	}
}
