package com.izuanqian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ILiveCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ILiveCenterApplication.class, args);
	}
}
