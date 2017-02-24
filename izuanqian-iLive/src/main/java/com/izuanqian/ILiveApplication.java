package com.izuanqian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ILiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ILiveApplication.class, args);
    }
}
