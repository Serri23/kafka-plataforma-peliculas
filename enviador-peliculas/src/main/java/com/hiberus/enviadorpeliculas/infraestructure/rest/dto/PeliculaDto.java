package com.hiberus.enviadorpeliculas.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PeliculaDto {

	private long id;
	
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private String fechaEstreno;
	
	private float duracion;
	
	private long visualizaciones;
	
}
