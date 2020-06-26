package com.cognizant.demo.configuration;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(paths())
	                .build()
	                .apiInfo(metaData())
	                .tags( new Tag("FinishedProducts Entity", "FinishedProducts Management API"),
	                        new Tag("PurchaseDetails Entity", "PurchaseDetails Management API"),
	                        new Tag("RawMaterials Entity", "RawMaterilas Management API"),
	                        new Tag("SellingDetails Entity", "SellingDetails Management API"),
	                        new Tag("Stock Entity", "Stock Management API"),
	                        new Tag("User Entity", "User Management API"))
	                .securitySchemes(Lists.newArrayList(apiKey()));
	    }

	    private ApiKey apiKey() {
	        return new ApiKey("Bearer", "Authorization", "header");
	    }

	    private Predicate<String> paths() {
	        return or(
	                regex("/inventory/users"),
	                regex("/inventory/stock"),
	                regex("/inventory/selling"),
	                regex("/inventory/rawMaterials/add"),
	                regex("/inventory/rawmaterials"),
	                regex("/inventory/purchase"),
	                regex("/inventory/finishedproducts"),
	                regex("/inventory/finishedproducts/update"));
	    }

	    private ApiInfo metaData() {
	        return new ApiInfo(
	                "Inventory Management API",
	                "Restful API to manage the Inventory Management Application.",
	                "V1.0",
	                "Terms of service",
	                new Contact("Pentakota Naveen Kumar", "https://github.com", "pentakota@gmail.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	    }

	    @Bean
	    UiConfiguration uiConfig() {
	        return UiConfigurationBuilder.builder()
	                .deepLinking(true)
	                .displayOperationId(false)
	                .defaultModelsExpandDepth(1)
	                .defaultModelExpandDepth(1)
	                .defaultModelRendering(ModelRendering.EXAMPLE)
	                .displayRequestDuration(false)
	                .docExpansion(DocExpansion.NONE)
	                .filter(false)
	                .maxDisplayedTags(null)
	                .operationsSorter(OperationsSorter.ALPHA)
	                .showExtensions(false)
	                .tagsSorter(TagsSorter.ALPHA)
	                .validatorUrl(null)
	                .build();
	    }

}
