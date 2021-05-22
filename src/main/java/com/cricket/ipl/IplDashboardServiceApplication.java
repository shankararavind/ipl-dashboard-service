package com.cricket.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cricket"})
@EnableJpaRepositories(basePackages = "com.cricket.repository")
@EntityScan(basePackages = "com.cricket.domain")
public class IplDashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplDashboardServiceApplication.class, args);
	}

}
