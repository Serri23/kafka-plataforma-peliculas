package com.hiberus.applicadorvaloraciones.domain.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "valoraciones")
public class Valoracion implements Serializable{

	@Id
	private long id;
	private long idPelicula;
	private float puntuacion;
	private String comentario;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="idPelicula")
//	Pelicula pelicula;
//
//	public Valoracion(long id, float puntuacion, String comentario) {
//		super();
//		this.id = id;
//		this.puntuacion = puntuacion;
//		this.comentario = comentario;
//	}
	
	
}
