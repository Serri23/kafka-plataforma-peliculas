package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
public class PeliculaValorada {
	
	@Id
	private Long id;
	
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private String fechaEstreno;
	
	private float duracion;
	
	private long visualizaciones;
	
	@ElementCollection(fetch = FetchType.EAGER,targetClass=Valoracion.class)
	List<Valoracion> valoraciones;
}
