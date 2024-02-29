package com.hiberus.applicadorvaloraciones.infraestructure.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface AplicadorValoracionesController {

	@Operation(summary = "Añadir una valoración a una película")
	@ApiResponse(responseCode = "200", description = "Peticion aceptada")
	void añadirValoracionAPelicula(Long idPelicula,Long idValoracion);	
}
