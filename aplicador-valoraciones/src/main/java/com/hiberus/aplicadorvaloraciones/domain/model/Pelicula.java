package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "peliculas")
public class Pelicula {

	@Id
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "fechaEstreno")
	private String fechaEstreno;
	
	@Column(name = "duracion")
	private float duracion;
	
	@Column(name = "visualizaciones")
	private long visualizaciones;
	
	@OneToMany(mappedBy="pelicula")
	private Set<Valoracion> valoraciones;
}
