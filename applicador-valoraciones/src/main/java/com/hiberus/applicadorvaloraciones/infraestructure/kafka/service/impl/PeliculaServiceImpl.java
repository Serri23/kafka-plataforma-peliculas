package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaService;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	PeliculaRepository peliculaRepository;
	
	@Autowired
	ValoracionRepository valoracionRepository;
	
	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	@Autowired
	PeliculaValoradaService peliculaValoradaService;
	
	public void eliminar(long id) {
		if(peliculaRepository.existsById(id)) {
			peliculaRepository.deleteById(id);
			if(peliculaValoradaRepository.existsById(id)) {
				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(id).get();
				peliculaValoradaRepository.deleteById(id);
				List<Valoracion> valoracionesABorrar = peliculaValorada.getValoraciones();
				valoracionRepository.deleteAllInBatch(valoracionesABorrar);
				peliculaValoradaService.eliminarPeliculaValorada(id);
			}
		}
		
	}

	
	public void crear(Pelicula pelicula) {
		if(!peliculaRepository.existsById(pelicula.getId())) {
			peliculaRepository.save(pelicula);
		}
	}

}
