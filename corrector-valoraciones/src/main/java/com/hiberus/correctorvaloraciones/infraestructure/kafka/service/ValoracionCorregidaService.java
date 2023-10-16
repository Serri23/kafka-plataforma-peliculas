package com.hiberus.correctorvaloraciones.infraestructure.kafka.service;

import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

public interface ValoracionCorregidaService {

	void crear(ValoracionKey valoracionKey, ValoracionValue valoracionValue);

	void eliminar(ValoracionKey valoracionKey);

}
