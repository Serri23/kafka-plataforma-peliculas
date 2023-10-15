package com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasValue;

@Component
public class Initializer implements org.apache.kafka.streams.kstream.Initializer<PeliculasValoradasMasVistasValue>{

	@Override
	public PeliculasValoradasMasVistasValue apply() {
		return PeliculasValoradasMasVistasValue.newBuilder()
                .setPeliculas(new ArrayList<>())
                .build();
	}

}
