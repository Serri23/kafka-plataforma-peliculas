package com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;

public interface ClasificadorMejoresPeliculasService {

	boolean clasificar(PeliculaValoradaValue peliculaValoradaValue);

}
