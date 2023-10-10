package com.hiberus.aplicadorvaloraciones.domain.service;

import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;

public interface ValoracionService{

	void eliminar(long id);

	void crear(Valoracion valoracion);

}
