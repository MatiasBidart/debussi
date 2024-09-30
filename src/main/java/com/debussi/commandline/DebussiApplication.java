package com.debussi.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DebussiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebussiApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(DatabaseConnection databaseConnection) {
		return args -> {
			databaseConnection.testConnection();
		};
	}
}
