package com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service;

import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValorada;

public interface PeliculaValoradaKafkaService{

	void enviarPeliculaValorada(PeliculaValorada peliculaValorada);

}
