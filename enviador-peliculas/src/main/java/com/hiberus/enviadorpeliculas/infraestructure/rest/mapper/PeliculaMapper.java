package com.hiberus.enviadorpeliculas.infraestructure.rest.mapper;

import org.mapstruct.Mapper;

import com.hiberus.enviadorpeliculas.domain.Pelicula;
import com.hiberus.enviadorpeliculas.infraestructure.rest.dto.PeliculaDto;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

	Pelicula peliculaDtoToPelicula(PeliculaDto peliculaDto);
}
