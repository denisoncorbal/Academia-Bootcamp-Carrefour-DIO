package me.dio.academia.digital;

import me.dio.academia.digital.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AcademiaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiaDigitalApplication.class, args);
	}

}