package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service;

import com.hiberus.applicadorvaloraciones.domain.model.ValoracionDomain;

public interface ValoracionService {

	void eliminar(long id);

	void crear(ValoracionDomain valoracion);

}
