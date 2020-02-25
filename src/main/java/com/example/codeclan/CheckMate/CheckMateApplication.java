package com.example.codeclan.CheckMate;

import com.example.codeclan.CheckMate.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CheckMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckMateApplication.class, args);
	}

}
