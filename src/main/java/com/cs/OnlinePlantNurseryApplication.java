package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePlantNurseryApplication.class, args);
	}

}
