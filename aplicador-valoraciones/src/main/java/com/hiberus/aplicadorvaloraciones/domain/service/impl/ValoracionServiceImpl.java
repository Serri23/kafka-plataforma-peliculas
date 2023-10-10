package com.hiberus.aplicadorvaloraciones.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.domain.service.ValoracionService;

public class ValoracionServiceImpl implements ValoracionService{
	
	@Autowired
	ValoracionRepository valoracionRepository;
	
	@Override
	public void eliminar(long id) {
		if(valoracionRepository.existsById(id)) {
			valoracionRepository.deleteById(id);
		}
	}

	@Override
	public void crear(Valoracion valoracion) {
		valoracionRepository.save(valoracion);
	}
}
