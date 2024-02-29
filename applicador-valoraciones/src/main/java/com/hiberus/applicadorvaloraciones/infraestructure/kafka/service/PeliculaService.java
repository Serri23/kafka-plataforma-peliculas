package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service;


import com.hiberus.applicadorvaloraciones.domain.model.Pelicula;


public interface PeliculaService {

	void eliminar(long id);

	void crear(Pelicula pelicula);

}
