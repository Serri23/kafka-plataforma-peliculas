package com.hiberus.consultadorpeliculas.domain.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.Valoracion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mejores_peliculas")
public class MejorPelicula {
		@Id
		Long id;
		String titulo;
		String descripcion;
		String categoria;
		String fechaEstreno;
		float duracion;
		long visualizaciones;
		@ElementCollection
		@CollectionTable(name="valoraciones_mejores_pelicula")
		List<Valoracion> valoraciones;

}