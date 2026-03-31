package com.crudback_mauro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TechBackAplication {

	public static void main(String[] args) {
		SpringApplication.run(TechBackAplication.class, args);
	}

}