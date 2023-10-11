package com.hiberus.aplicadorvaloraciones.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Pelicula {

	@Id
	private Long id;
	@Column(name = "puntuacion")
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private String fechaEstreno;
	
	private float duracion;
	
	private long visualizaciones;
	
//	@OneToMany(mappedBy="pelicula")
//	private Set<Valoracion> valoraciones;
	
//	@OneToMany( mappedBy = "pelicula", cascade = CascadeType.ALL )
//    private Set<PeliculaValorada> peliculasValoradas;

	public Pelicula(Long id, String titulo, String descripcion, String categoria, String fechaEstreno, float duracion,
			long visualizaciones) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.fechaEstreno = fechaEstreno;
		this.duracion = duracion;
		this.visualizaciones = visualizaciones;
	}
}
