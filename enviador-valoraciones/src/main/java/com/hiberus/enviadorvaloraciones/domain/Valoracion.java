package com.hiberus.enviadorvaloraciones.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Valoracion {
	
	private long id;
	
	private long idPelicula;
	
	private float puntuacion;
	
	private String comentario;	
}
