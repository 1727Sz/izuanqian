package com.izuanqian.ilive.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ILiveImApplication {

	public static void main(String[] args) {
		SpringApplication.run(ILiveImApplication.class, args);
	}
}
