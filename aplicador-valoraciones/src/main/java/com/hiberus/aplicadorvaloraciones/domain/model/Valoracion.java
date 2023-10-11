package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@AllArgsConstructor
public class Valoracion {
	
	@Id
	private long id;
	
	private long idPelicula;
	
	private float puntuacion;
	
	private String comentario;	
	

//	@ManyToOne
//	@JoinColumn(name="idPelicula",nullable=false)
//	private Pelicula pelicula;
	@OneToMany( mappedBy = "valoracion", cascade = CascadeType.ALL )
	List<PeliculaValorada> peliculasValoradas;

	public Valoracion(long id, long idPelicula, float puntuacion, String comentario) {
		super();
		this.id = id;
		this.idPelicula = idPelicula;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
}
