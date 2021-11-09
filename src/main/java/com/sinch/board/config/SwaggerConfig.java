package com.sinch.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaData())

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sinch.board.controller"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Leader Board Rest API")
                .description("Swagger documentation for the all REST-Endpoint services by Sunilkumar Mohandas for use in the Leader Board Application")
                .termsOfServiceUrl(null)
                .contact(new Contact(
                        "Sunilkumar Mohandas",
                        null,
                        "sunilkumar.m45@gmail.com"
                ))
                .license(null)
                .licenseUrl(null)
                .version("v1")
                .build();
    }
}
