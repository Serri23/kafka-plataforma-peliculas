package com.hiberus.consultadorpeliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hiberus.consultadorpeliculas.infraestructure.kafka.BinderProcessor;


@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class ConsultadorPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultadorPeliculasApplication.class, args);
	}

}
