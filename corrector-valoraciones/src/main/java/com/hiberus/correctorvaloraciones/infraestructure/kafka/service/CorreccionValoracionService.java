package com.hiberus.correctorvaloraciones.infraestructure.kafka.service;

import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

public interface CorreccionValoracionService {

	ValoracionValue corregirValoracion(ValoracionValue valoracionValue);

}
