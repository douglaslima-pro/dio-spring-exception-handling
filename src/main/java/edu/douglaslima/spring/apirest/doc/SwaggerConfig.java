package edu.douglaslima.spring.apirest.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Minha primeira API REST")
						.description("API REST desenvolvida no Bootcamp de Java fornecido pelo Santander na DIO.")
						.version("1.0")
						.contact(new Contact()
									.name("Douglas Souza de Lima")
									.url("https://github.com/douglaslima-pro")
									.email("douglaslima-pro@outlook.com"))
						.termsOfService("Termo de uso: Open Source"));
	}
	
}
