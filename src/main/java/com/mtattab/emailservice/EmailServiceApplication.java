package com.mtattab.emailservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition
@EntityScan("com.mtattab.emailservice.entity")
@EnableJdbcHttpSession

public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
