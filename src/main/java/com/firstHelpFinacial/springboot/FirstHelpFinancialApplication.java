package com.firstHelpFinacial.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FirstHelpFinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstHelpFinancialApplication.class, args);
	}

}
