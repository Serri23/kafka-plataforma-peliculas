package com.hiberus.aplicadorvaloraciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.BinderProcessor;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class AplicadorValoracionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicadorValoracionesApplication.class, args);
	}

}
