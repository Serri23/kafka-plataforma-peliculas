package com.hiberus.enviadorvaloraciones.infraestructure.rest.mapper;

import org.mapstruct.Mapper;

import com.hiberus.enviadorvaloraciones.domain.Valoracion;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.dto.ValoracionDto;

@Mapper(componentModel = "spring")
public interface ValoracionMapper {
	
	Valoracion valoracionDtoToValoracion(ValoracionDto valoracionDto);

}
