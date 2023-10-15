package com.hiberus.applicadorvaloraciones.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;

@Mapper (componentModel = "spring")
public interface PeliculaValoradaKafkaMapper {

	PeliculaValoradaValue peliculaValoradaToPeliculaValoradaValue(PeliculaValorada peliculaValorada);
}
