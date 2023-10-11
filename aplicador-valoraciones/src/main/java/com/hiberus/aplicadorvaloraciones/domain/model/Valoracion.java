package com.hiberus.aplicadorvaloraciones.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Valoracion {
	
	@Id
	private long id;
	
	@Column(name = "puntuacion")
	private float puntuacion;
	@Column(name = "comentario")
	private String comentario;	
	

//	@ManyToOne
//	@JoinColumn(name="idPelicula",nullable=false)
//	private Pelicula pelicula;
//	@OneToMany( mappedBy = "valoracion", cascade = CascadeType.ALL )
//	List<PeliculaValorada> peliculasValoradas;

	public Valoracion(long id,float puntuacion, String comentario) {
		super();
		this.id = id;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
}
