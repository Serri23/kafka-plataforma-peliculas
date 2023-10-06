package com.hiberus.enviadorvaloraciones.infraestructure.rest.controller;

import com.hiberus.enviadorvaloraciones.infraestructure.rest.dto.ValoracionDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ValoracionController{

	@Operation(summary = "Crear una valoracion")
	@ApiResponses({
		@ApiResponse(responseCode="202", description = "Valoracion enviada"),
		@ApiResponse(responseCode="400", description = "Valoracion incorrecta")
	})
	void crearValoracion(ValoracionDto valoracionDto);
	
	@Operation(summary = "Eliminar una valoracion")
	@ApiResponse(responseCode="202", description = "Peticion enviada")
	void eliminarValoracion(Long id);
}
