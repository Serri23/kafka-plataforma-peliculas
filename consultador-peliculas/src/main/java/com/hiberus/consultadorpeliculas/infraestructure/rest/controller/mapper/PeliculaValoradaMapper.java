package com.hiberus.consultadorpeliculas.infraestructure.rest.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.infraestructure.rest.controller.dto.PeliculaValoradaDto;

@Mapper(componentModel = "spring")
public interface PeliculaValoradaMapper {

	List<PeliculaValoradaDto> peliculasValoradasToPeliculasValoradasDto(List<PeliculaValorada> peliculasValoradas);

	PeliculaValoradaDto peliculaValoradaToPeliculaValoradaDto(PeliculaValorada peliculaValorada);
}
