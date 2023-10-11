package com.hiberus.aplicadorvaloraciones.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class PeliculaValoradaId implements Serializable{

	long idPelicula;
	
	long idValoracion;
}
