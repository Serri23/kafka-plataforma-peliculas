package com.hiberus.aplicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface BinderProcessor {
	
	String PELICULAS = "peliculas";
	
	String VALORACIONES = "valoraciones";
	
	String PELICULAS_VALORADAS = "peliculas_valoradas";
	
	@Input(PELICULAS)
	KStream<?,?> procesarPeliculas();
	
	@Input(VALORACIONES)
	KStream<?,?> procesarValoraciones();
	
	@Output(PELICULAS_VALORADAS)
	KStream<?,?> procesarPeliculasValoradas();

}
