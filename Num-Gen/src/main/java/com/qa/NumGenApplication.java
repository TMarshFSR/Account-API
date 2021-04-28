package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NumGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumGenApplication.class, args);
	}

}
