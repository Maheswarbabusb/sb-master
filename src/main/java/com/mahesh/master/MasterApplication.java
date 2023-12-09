package com.mahesh.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterApplication.class, args);
	}

}
