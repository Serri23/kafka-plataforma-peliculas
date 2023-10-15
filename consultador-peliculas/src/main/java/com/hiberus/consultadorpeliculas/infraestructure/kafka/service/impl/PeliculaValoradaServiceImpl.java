package com.hiberus.consultadorpeliculas.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.domain.repository.PeliculaValoradaRepository;
import com.hiberus.consultadorpeliculas.infraestructure.kafka.service.PeliculaValoradaService;

@Service
public class PeliculaValoradaServiceImpl implements PeliculaValoradaService{

	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	public void crearPeliculaValorada(PeliculaValorada peliculaValorada) {
		peliculaValoradaRepository.save(peliculaValorada);
	}

	
	public void eliminarPeliculaValorada(long id) {
		peliculaValoradaRepository.deleteById(id);
	}

}
