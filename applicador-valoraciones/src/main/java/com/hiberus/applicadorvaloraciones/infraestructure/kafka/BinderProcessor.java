package com.hiberus.applicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {
	
	String PELICULAS = "peliculas";
	
	String VALORACIONES = "valoraciones_corregidas";
		
	@Input(PELICULAS)
	KStream<?,?> peliculas();
	
	@Input(VALORACIONES)
	KStream<?,?> valoraciones();
}
