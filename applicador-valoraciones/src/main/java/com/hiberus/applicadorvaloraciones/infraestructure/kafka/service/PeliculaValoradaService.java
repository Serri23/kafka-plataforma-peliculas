package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service;

import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;

@Service
public interface PeliculaValoradaService {

	void crearPeliculaValorada(PeliculaValorada pelicula);

	void eliminarPeliculaValorada(Long id);
}
