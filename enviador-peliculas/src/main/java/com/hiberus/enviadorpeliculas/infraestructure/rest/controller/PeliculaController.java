package com.hiberus.enviadorpeliculas.infraestructure.rest.controller;

import com.hiberus.enviadorpeliculas.infraestructure.rest.dto.PeliculaDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PeliculaController {
	
	@Operation(summary = "Crear una pelicula")
	@ApiResponse(responseCode="202",description = "Pelicula enviada")
	void crearPelicula(PeliculaDto peliculaDto);
	
	@Operation(summary = "Eliminar una pelicula")
	@ApiResponse(responseCode="202",description = "Peticion enviada")
	void eliminarPelicula(Long id);

}
