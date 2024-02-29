package com.hiberus.consultadorpeliculas.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.consultadorpeliculas.domain.model.MejorPelicula;
import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.domain.repository.MejorPeliculaRepository;
import com.hiberus.consultadorpeliculas.domain.repository.PeliculaValoradaRepository;
import com.hiberus.consultadorpeliculas.infraestructure.kafka.service.PeliculaValoradaService;

@Service
public class PeliculaValoradaServiceImpl implements PeliculaValoradaService{

	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	@Autowired
	MejorPeliculaRepository mejorPeliculaRepository;
	
	public void crearPeliculaValorada(PeliculaValorada peliculaValorada) {
		peliculaValoradaRepository.save(peliculaValorada);
	}

	
	public void eliminarPeliculaValorada(long id) {
		peliculaValoradaRepository.deleteById(id);
	}


	
	public void crearMejorPelicula(MejorPelicula mejorPelicula) {
		mejorPeliculaRepository.save(mejorPelicula);
	}


	public void eliminarMejorPelicula(long id) {
		mejorPeliculaRepository.deleteById(id);	
	}

}
