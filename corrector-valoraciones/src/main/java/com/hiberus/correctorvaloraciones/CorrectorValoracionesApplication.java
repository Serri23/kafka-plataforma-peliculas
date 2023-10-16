package com.hiberus.correctorvaloraciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hiberus.correctorvaloraciones.infraestructure.kafka.BinderProcessor;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class CorrectorValoracionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrectorValoracionesApplication.class, args);
	}

}
