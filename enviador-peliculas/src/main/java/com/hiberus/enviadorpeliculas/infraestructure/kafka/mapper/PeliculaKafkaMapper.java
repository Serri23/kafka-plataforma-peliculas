package com.hiberus.enviadorpeliculas.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;

import com.hiberus.enviadorpeliculas.domain.Pelicula;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.avro.PeliculaValue;

@Mapper (componentModel = "spring")
public interface PeliculaKafkaMapper {
	
	PeliculaValue peliculaToPeliculaValue(Pelicula pelicula);

}
