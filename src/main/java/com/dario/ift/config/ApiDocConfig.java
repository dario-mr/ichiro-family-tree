package com.dario.ift.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

@Configuration
public class ApiDocConfig {

    @Value("${api.key.header}")
    private String apiKeyHeader;

    @Bean
    public OpenAPI config() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ichiro Family Tree")
                        .description("API that returns the family tree of our doggy Ichiro Go Takimisou")
                        .version("1.0"));
    }

    // Add api-key to swagger requests header
    @Bean
    public OperationCustomizer apiDocHeaders() {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            Parameter apiKey = new Parameter()
                    .in(ParameterIn.HEADER.toString())
                    .schema(new StringSchema())
                    .name(apiKeyHeader)
                    .description("API key")
                    .required(true);
            operation.addParametersItem(apiKey);

            return operation;
        };
    }

    @Bean
    public MvcConfig mvcConfig() {
        return new MvcConfig();
    }

}
