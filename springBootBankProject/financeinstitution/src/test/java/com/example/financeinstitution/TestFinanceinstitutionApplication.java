package com.example.financeinstitution;

import org.springframework.boot.SpringApplication;

public class TestFinanceinstitutionApplication {

	public static void main(String[] args) {
		SpringApplication.from(FinanceinstitutionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
