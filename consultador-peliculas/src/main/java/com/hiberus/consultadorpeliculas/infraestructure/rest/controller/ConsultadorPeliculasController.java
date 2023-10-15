package com.hiberus.consultadorpeliculas.infraestructure.rest.controller;


import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface ConsultadorPeliculasController {

	@Operation(summary = "Listar peliculas valoradas")
	@ApiResponse(responseCode = "200", description = "Peliculas valoradas listadas")
	ResponseEntity<Object> listarPeliculasValoradas();
	
	@Operation(summary = "Obtener una pelicula valorada")
	@ApiResponse(responseCode = "200", description = "Pelicula valorada listada")
	ResponseEntity<Object> obtenerPeliculaValorada(Long idPelicula) throws JsonProcessingException;
	
}
