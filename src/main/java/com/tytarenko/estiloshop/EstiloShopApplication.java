package com.tytarenko.estiloshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vladyslav on 1/4/2018
 */

@EnableJpaRepositories(basePackages = "com.tytarenko.estiloshop.dao")
@SpringBootApplication
public class EstiloShopApplication{

	public static void main(String[] args) {
		SpringApplication.run(EstiloShopApplication.class, args);
	}
}
