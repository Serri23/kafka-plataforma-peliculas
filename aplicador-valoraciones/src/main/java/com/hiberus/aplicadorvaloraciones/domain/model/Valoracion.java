package com.hiberus.aplicadorvaloraciones.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "valoraciones")
public class Valoracion {
	
	@Id
	private long id;
	
	@Column(name = "idPelicula")
	private long idPelicula;
	
	@Column(name = "puntuacion")
	private float puntuacion;
	
	@Column(name = "comentario")
	private String comentario;	
	

	@ManyToOne
	@JoinColumn(name="idPelicula",nullable=false)
	private Pelicula pelicula;

	public Valoracion(long id, long idPelicula, float puntuacion, String comentario) {
		super();
		this.id = id;
		this.idPelicula = idPelicula;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
}
