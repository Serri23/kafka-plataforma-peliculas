package com.hiberus.aplicadorvaloraciones.domain.model;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeliculaValorada {
	
	@EmbeddedId
	PeliculaValoradaId id;
	
	@ManyToOne()
    @JoinColumn(name = "valoracion_de_pelicula_pelicula")
    @MapsId("pelicula")
    Pelicula pelicula;
	
	@ManyToOne()
    @JoinColumn(name = "valoracion_de_pelicula_valoracion")
    @MapsId("valoracion")
    Valoracion valoracion;

    
	
	
}
