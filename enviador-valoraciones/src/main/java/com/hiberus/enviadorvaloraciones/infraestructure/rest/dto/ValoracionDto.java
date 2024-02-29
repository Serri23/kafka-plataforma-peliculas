package com.hiberus.enviadorvaloraciones.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValoracionDto {

	long id;
	
	long idPelicula;
	
	float puntuacion;
	
	String comentario;
}
