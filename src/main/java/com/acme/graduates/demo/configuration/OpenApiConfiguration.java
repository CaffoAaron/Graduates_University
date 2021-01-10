package com.acme.graduates.demo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "graduatesOpenApi")
    public OpenAPI graduatesOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Graduates Application API")
                        .description(
                                "Graduates API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));

    }

}
