package br.com.fluffynow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "br.com.fluffynow.api.*")
@EntityScan("br.com.fluffynow.api.*")
@EnableJpaRepositories(basePackages = "br.com.fluffynow.api.*")
@SpringBootApplication()
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
