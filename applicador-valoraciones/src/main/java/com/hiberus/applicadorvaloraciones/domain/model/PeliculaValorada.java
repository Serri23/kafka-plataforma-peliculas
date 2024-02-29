package com.hiberus.applicadorvaloraciones.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "peliculas_valoradas")
public class PeliculaValorada{
	
	@Id
	Long id;
	String titulo;
	String descripcion;
	String categoria;
	String fechaEstreno;
	float duracion;
	long visualizaciones;
	@ElementCollection(targetClass = ValoracionDomain.class, fetch = FetchType.EAGER)
	@CollectionTable(name="valoraciones_pelicula", joinColumns = @JoinColumn(name ="id_pelicula"))
	@Column(name = "valoracion", nullable = false)
	List<ValoracionDomain> valoraciones;
	
	public PeliculaValorada(Pelicula pelicula){
		this.id = pelicula.id;
		this.titulo = pelicula.titulo;
		this.descripcion = pelicula.descripcion;
		this.categoria = pelicula.categoria;
		this.fechaEstreno = pelicula.fechaEstreno;
		this.duracion = pelicula.duracion;
		this.visualizaciones = pelicula.visualizaciones;
		this.valoraciones = new ArrayList<ValoracionDomain>();
	}
	
}
