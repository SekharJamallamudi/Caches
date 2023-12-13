package com.app.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class RespApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RespApiCrudApplication.class, args);
	}

}
