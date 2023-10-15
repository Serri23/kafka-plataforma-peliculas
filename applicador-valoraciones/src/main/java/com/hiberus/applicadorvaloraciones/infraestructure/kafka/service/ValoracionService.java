package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service;



import com.hiberus.applicadorvaloraciones.domain.model.Valoracion;

public interface ValoracionService {

	void eliminar(long id);

	void crear(Valoracion valoracion);

}
