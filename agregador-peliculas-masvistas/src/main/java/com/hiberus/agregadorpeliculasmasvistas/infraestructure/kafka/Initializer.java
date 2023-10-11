package com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka;

import java.util.ArrayList;

import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasValue;

public class Initializer implements org.apache.kafka.streams.kstream.Initializer<PeliculasValoradasMasVistasValue>{

	@Override
	public PeliculasValoradasMasVistasValue apply() {
		return PeliculasValoradasMasVistasValue.newBuilder()
                .setPeliculas(new ArrayList<>())
                .build();
	}

}
