package org.query.calc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.query.model.entity","org.query.repository"})
@EntityScan("org.query")
@EnableJpaRepositories(basePackages  = "org.query.repository")
@PropertySource("classpath:application.properties")
public class QueryTestTaskApplication {

		
	
	public static void main(String[] args) {
		SpringApplication.run(QueryTestTaskApplication.class, args);
		System.out.println();
	}

}
