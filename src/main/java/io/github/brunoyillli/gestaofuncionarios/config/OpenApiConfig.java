package io.github.brunoyillli.gestaofuncionarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Sistema de Gestão de Funcionários API")
                        .description("API do Sistema de Gestão de Funcionários")
                        .version("1.0.0"));
    }
}
