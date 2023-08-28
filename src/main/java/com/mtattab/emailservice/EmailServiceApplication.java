package com.mtattab.emailservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition
//@EnableSwagger2WebMvc  // Enable Swagger with SpringDoc-OpenAPI
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
