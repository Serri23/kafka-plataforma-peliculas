package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.ValoracionService;

@Service
public class ValoracionServiceImpl implements ValoracionService{

	@Autowired
	ValoracionRepository valoracionRepository;
	
	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	public void eliminar(long id) {
		if(valoracionRepository.existsById(id)) {
			Valoracion valoracion = valoracionRepository.findById(id).get();
			if(peliculaValoradaRepository.existsById(valoracion.getIdPelicula())) {
				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(valoracion.getIdPelicula()).get();
				peliculaValoradaRepository.deleteById(peliculaValorada.getId());
				peliculaValorada.getValoraciones().remove(peliculaValorada.getValoraciones().stream().filter(v -> id == v.getId()).findAny().get());
				if(peliculaValorada.getValoraciones().size() > 0) 
				peliculaValoradaRepository.save(peliculaValorada);
			}
			valoracionRepository.deleteById(id);
			
		}
		
	}

	
	public void crear(Valoracion valoracion) {
		if(!valoracionRepository.existsById(valoracion.getId())) {
			valoracionRepository.save(valoracion);
		}
	}

}
