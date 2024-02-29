package com.hiberus.agrupadorpeliculas.infraestructure.kafka;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.PeliculaPorCategoriaValue;


@Component
public class Initializer implements org.apache.kafka.streams.kstream.Initializer<PeliculaPorCategoriaValue>{

	@Override
	public PeliculaPorCategoriaValue apply() {
		return PeliculaPorCategoriaValue.newBuilder()
                .setPeliculas(new ArrayList<>())
                .build();
	}

}
