package com.evaluacion.truper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API REST EvaluaciÓn TRUPER")
                .version("v1")
                .description("Documentación API REST")
                .contact(new Contact().name("Soporte").email("manuelyv81@gmail.com")));
    }
}
