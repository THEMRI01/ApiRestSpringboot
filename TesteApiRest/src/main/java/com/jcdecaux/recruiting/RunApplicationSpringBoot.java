package com.jcdecaux.recruiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class RunApplicationSpringBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplicationSpringBoot.class, args);
	}
	

}
