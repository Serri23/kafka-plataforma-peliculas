package com.hiberus.aplicadorvaloraciones.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Valoracion {
	
	@Id
	private long id;
	
	@Column(name = "puntuacion")
	private float puntuacion;
	@Column(name = "comentario")
	private String comentario;	
	

	@ManyToOne
	@JoinColumn(name="idPelicula",nullable=false)
	Pelicula pelicula;
//	@OneToMany( mappedBy = "valoracion", cascade = CascadeType.ALL )
//	List<PeliculaValorada> peliculasValoradas;

	public Valoracion(long id,float puntuacion, String comentario) {
		super();
		this.id = id;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
}
