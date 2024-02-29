package com.hiberus.applicadorvaloraciones.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "peliculas")
public class Pelicula {

	@Id
	Long id;
	String titulo;
	String descripcion;
	String categoria;
	String fechaEstreno;
	float duracion;
	long visualizaciones;
	

	public Pelicula(Long id, String titulo, String descripcion, String categoria, String fechaEstreno,
			float duracion, long visualizaciones) {
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
