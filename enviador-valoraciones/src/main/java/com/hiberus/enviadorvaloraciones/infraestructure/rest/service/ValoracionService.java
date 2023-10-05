package com.hiberus.enviadorvaloraciones.infraestructure.rest.service;

import com.hiberus.enviadorvaloraciones.infraestructure.domain.Valoracion;

public interface ValoracionService {

	void crearValoracion(Valoracion valoracion);

	void eliminarValoracion(Long id);

}
