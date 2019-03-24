package com.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulbackendApplication.class, args);
	}

}
