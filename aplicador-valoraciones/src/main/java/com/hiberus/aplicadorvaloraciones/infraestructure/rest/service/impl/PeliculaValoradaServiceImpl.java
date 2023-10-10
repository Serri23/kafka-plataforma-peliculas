package com.hiberus.aplicadorvaloraciones.infraestructure.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;
import com.hiberus.aplicadorvaloraciones.infraestructure.rest.service.PeliculaValoradaService;

public class PeliculaValoradaServiceImpl implements PeliculaValoradaService{

	@Autowired
	PeliculaRepository peliculaRepository;
	
	@Autowired
	ValoracionRepository valoracionRepository;
	
	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	@Autowired
	PeliculaValoradaKafkaService peliculaValoradaKafkaService;
	
	public void añadirValoracionAPelicula(Long idPelicula, Long idValoracion) {
		
		if(!valoracionRepository.existsById(idValoracion)) {
			Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
			if(!peliculaValoradaRepository.existsById(idPelicula)) {
				List<Valoracion> valoraciones = new ArrayList<>();
				valoraciones.add(valoracion);
				Pelicula pelicula = peliculaRepository.findById(idPelicula).get();
				PeliculaValorada peliculaValorada = new PeliculaValorada(pelicula, valoraciones);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
			}else {
				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(idPelicula).get();
				peliculaValorada.getValoraciones().add(valoracion);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
			}
		}
		
	}

	@Override
	public void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion) {
		
		if(valoracionRepository.existsById(idValoracion)) {
			Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
			PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(idPelicula).get();
			peliculaValoradaRepository.delete(peliculaValorada);
			peliculaValorada.getValoraciones().remove(valoracion);
			peliculaValoradaRepository.save(peliculaValorada);
			
			//kafka
			
		}
		
	}
}
