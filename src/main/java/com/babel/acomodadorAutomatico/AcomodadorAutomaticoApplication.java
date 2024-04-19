package com.babel.acomodadorAutomatico;

import com.babel.acomodadorAutomatico.config.AppConfig;
import com.babel.acomodadorAutomatico.start.StartAcomodadorAutomatico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AcomodadorAutomaticoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StartAcomodadorAutomatico acomodadorAutomatico = context.getBean(StartAcomodadorAutomatico.class);
		acomodadorAutomatico.start();
	}
}
