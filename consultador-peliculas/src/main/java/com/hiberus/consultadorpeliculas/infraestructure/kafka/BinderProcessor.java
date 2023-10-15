package com.hiberus.consultadorpeliculas.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {

	String PELICULAS_VALORADAS = "peliculas_valoradas";
	
	@Input(PELICULAS_VALORADAS)
	KStream<?,?> peliculasValoradas();
}
