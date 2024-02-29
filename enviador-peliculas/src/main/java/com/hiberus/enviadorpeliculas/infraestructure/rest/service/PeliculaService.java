package com.hiberus.enviadorpeliculas.infraestructure.rest.service;

import com.hiberus.enviadorpeliculas.domain.Pelicula;

public interface PeliculaService {
	
	void crearPelicula(Pelicula pelicula);
	
	void eliminarPelicula(Long id);

}
