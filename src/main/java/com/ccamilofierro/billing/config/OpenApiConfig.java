package com.ccamilofierro.billing.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
@Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API de Facturación")
                    .description("API para la gestión de facturas")
                    .version("1.0")
                    .contact(new Contact()
                        .name("Cristian Fierro")
                        .email("ccamilofierro@email.com"))
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                    .description("Documentación adicional")
                    .url("https://github.com/java-ccamilofierro/Billing/readme.md"));
    }
}

