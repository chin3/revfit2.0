package com.revature.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.revature")
@EnableJpaRepositories("com.revature.repositories")
@EntityScan("com.revature.beans")
public class RevFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevFitApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configurer(){
	  return new WebMvcConfigurer(){
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	      registry.addMapping("/*")
	          .allowedOrigins("*");
	    }
	 };
	}
}
