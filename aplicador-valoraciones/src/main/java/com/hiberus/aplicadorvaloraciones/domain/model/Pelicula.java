package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

	@Id
	private Long id;
	
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private String fechaEstreno;
	
	private float duracion;
	
	private long visualizaciones;
	
//	@OneToMany(mappedBy="pelicula")
//	private Set<Valoracion> valoraciones;
	
	@OneToMany( mappedBy = "pelicula", cascade = CascadeType.ALL )
    private Set<PeliculaValorada> valoraciones;

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
