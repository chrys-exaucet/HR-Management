package org.human.resources.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("V1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("org.human.resources"))
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "HR REST API",
            "Exposing  REST endpoints for employees management",
            "v1.0",
            "",
            new Contact("Chrys Exaucet", "https://github.com/chrys-exaucet", "chrysexaucet@hotmail.fr"),
            "CC BY-SA 3.0",
            "https://creativecommons.org/licenses/by-sa/3.0/",
            Collections.emptyList());
    }

}
