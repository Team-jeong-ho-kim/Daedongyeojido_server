package com.example.daedongyeojido_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DaedongyeojidoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaedongyeojidoServerApplication.class, args);
	}

}
