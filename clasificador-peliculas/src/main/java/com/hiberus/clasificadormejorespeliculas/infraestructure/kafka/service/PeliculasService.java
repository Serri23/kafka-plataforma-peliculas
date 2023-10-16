package com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;

public interface PeliculasService {

	void crear(PeliculaValoradaKey peliculaValoradaKey, PeliculaValoradaValue peliculaValoradaValue);

	void eliminar(PeliculaValoradaKey peliculaValoradaKey);

}
