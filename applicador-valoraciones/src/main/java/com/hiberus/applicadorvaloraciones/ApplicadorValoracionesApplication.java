package com.hiberus.applicadorvaloraciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.BinderProcessor;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class ApplicadorValoracionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicadorValoracionesApplication.class, args);
	}

}
