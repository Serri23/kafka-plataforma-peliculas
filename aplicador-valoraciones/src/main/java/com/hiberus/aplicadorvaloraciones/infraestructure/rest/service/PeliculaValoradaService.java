package com.hiberus.aplicadorvaloraciones.infraestructure.rest.service;

public interface PeliculaValoradaService {

	void añadirValoracionAPelicula(Long idPelicula, Long idValoracion);

	void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion);

	
}
