package com.onestep.spring.springboot_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.RequiredArgsConstructor;


@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}

}
