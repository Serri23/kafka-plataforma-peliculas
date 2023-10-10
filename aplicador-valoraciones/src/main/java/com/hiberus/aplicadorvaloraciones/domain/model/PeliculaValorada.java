package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class PeliculaValorada {
	
	@Id
	Long id;
	
	Pelicula pelicula;
	
	List<Valoracion> valoraciones;

	public PeliculaValorada(Pelicula pelicula, List<Valoracion> valoraciones) {
		super();
		this.id = this.pelicula.getId();
		this.pelicula = pelicula;
		this.valoraciones = valoraciones;
	}
	
	
}
