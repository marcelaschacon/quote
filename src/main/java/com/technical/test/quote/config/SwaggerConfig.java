package com.technical.test.quote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).tags(new Tag("Quote", "API")).apiInfo(apiInfo())
		        .groupName("QuoteApp").select().paths(PathSelectors.ant("/v1/**")).build().pathMapping("/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("BUDGET REQUEST").description("Endpoints for the insurance system").version("1.0").build();
	}
	
}
