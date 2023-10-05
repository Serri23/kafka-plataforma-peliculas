package com.hiberus.enviadorvaloraciones.infraestructure.rest.mapper;

import com.hiberus.enviadorvaloraciones.infraestructure.domain.Valoracion;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.dto.ValoracionDto;

public interface ValoracionMapper {

	Valoracion valoracionDtoToValoracion(ValoracionDto valoracionDto);
}
