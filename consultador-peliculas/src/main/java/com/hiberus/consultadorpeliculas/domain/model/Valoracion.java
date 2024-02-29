package com.hiberus.consultadorpeliculas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Valoracion {

	private long id;
	private float puntuacion;
	private String comentario;
	
}
