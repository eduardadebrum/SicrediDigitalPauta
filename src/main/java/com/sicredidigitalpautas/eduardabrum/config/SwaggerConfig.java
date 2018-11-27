package com.sicredidigitalpautas.eduardabrum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Classe de Configuração do Swagger.
 *
 * @author Eduarda de Brum Lucena
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {

        Contact contact = new Contact(
                "Eduarda de Brum Lucena",
                "https://www.linkedin.com/in/eduarda-de-brum-lucena-a45834a6/",
                "eduardadebrum94@gmail.com");

        return new ApiInfo(
                "Sicredi Digital",
                "Essa é a documentação para o Sicredi Digital API. Essa API visa disponiblizar serviços " +
                        "relacionados a gestão de Pautas.",
                "1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>());
    }
}