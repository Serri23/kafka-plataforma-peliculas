package com.hiberus.applicadorvaloraciones.infraestructure.kafka.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.domain.model.ValoracionDomain;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.Valoracion;

@Mapper (componentModel = "spring")
public interface PeliculaValoradaKafkaMapper {

	PeliculaValoradaValue peliculaValoradaToPeliculaValoradaValue(PeliculaValorada peliculaValorada);
	
	List<Valoracion> valoracionesDominioAValoracionesAvro (List<ValoracionDomain> valoracionesDominio);
}
