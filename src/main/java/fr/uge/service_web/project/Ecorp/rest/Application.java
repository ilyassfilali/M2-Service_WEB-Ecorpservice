package fr.uge.service_web.project.Ecorp.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import fr.uge.service_web.project.Ecorp.rest.conf.SwaggerConfiguration;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
