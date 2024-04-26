package com.example.systems_management;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemsManagementApplication.class, args);
	}
}
