package com.hiberus.consultadorpeliculas.infraestructure.kafka.service;

import com.hiberus.consultadorpeliculas.domain.model.MejorPelicula;
import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;

public interface PeliculaValoradaService {

	void crearPeliculaValorada(PeliculaValorada peliculaValorada);

	void eliminarPeliculaValorada(long id);

	void crearMejorPelicula(MejorPelicula mejorPelicula);

	void eliminarMejorPelicula(long id);

}
