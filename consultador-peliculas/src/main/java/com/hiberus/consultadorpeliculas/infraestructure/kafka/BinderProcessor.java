package com.hiberus.consultadorpeliculas.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {

	String PELICULAS_VALORADAS = "peliculas_valoradas";
	
	String MEJORES_PELICULAS = "mejores_peliculas";
	
	@Input(PELICULAS_VALORADAS)
	KStream<?,?> peliculasValoradas();
	
	@Input(MEJORES_PELICULAS)
	KStream<?,?> mejoresPeliculas();
}
