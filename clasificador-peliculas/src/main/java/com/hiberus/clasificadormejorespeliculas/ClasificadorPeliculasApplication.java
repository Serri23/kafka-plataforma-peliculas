package com.hiberus.clasificadormejorespeliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.BinderProcessor;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class ClasificadorPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasificadorPeliculasApplication.class, args);
	}

}
