package com.cognizant.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class InventoryMangementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMangementSystemApplication.class, args);
	}

}
