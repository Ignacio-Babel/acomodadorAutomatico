package com.babel.acomodadorAutomatico.config;

import com.babel.acomodadorAutomatico.models.Cinema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.babel.acomodadorAutomatico")
public class AppConfig {
	@Bean
	public Cinema cinema() {
		return new Cinema(9, 10);
	}
}
