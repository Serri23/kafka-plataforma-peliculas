package com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;

public interface PeliculaValoradaKafkaService{

	void crearPeliculaValorada(Pelicula peliculaValorada);

}
