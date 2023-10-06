package com.hiberus.enviadorvaloraciones.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;

import com.hiberus.enviadorvaloraciones.domain.Valoracion;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

@Mapper(componentModel = "spring")
public interface ValoracionKafkaMapper {

	ValoracionValue valoracionToValoracionValue(Valoracion valoracion);
}
