package com.hiberus.enviadorpeliculas.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pelicula {
	private long id;
	
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private String fechaEstreno;
	
	private float duracion;
	
	private long visualizaciones;

}
