package com.hiberus.applicadorvaloraciones.domain.model;


import javax.persistence.Entity;
import javax.persistence.Id;
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
public class ValoracionDomain{

	@Id
	private long id;
	private long idPelicula;
	private float puntuacion;
	private String comentario;	
}
