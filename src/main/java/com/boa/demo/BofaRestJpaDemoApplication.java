package com.boa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories("com.boa.repo")
@EntityScan("com.boa.entity")
@ComponentScan("com.boa.*")
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication

public class BofaRestJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BofaRestJpaDemoApplication.class, args);
	}

}
