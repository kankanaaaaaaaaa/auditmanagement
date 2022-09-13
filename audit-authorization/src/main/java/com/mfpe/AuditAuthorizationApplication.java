package com.mfpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

public class AuditAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditAuthorizationApplication.class, args);
		System.out.println("Audit-Authorization MS - Started");
	}

}
