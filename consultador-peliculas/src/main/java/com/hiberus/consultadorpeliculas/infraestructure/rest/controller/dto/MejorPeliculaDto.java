package com.hiberus.consultadorpeliculas.infraestructure.rest.controller.dto;

import java.util.List;

import com.hiberus.consultadorpeliculas.domain.model.Valoracion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MejorPeliculaDto {

	Long id;
	String titulo;
	String descripcion;
	String categoria;
	String fechaEstreno;
	float duracion;
	long visualizaciones;
	List<Valoracion> valoraciones;
}
