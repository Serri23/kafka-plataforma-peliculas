package com.hiberus.aplicadorvaloraciones.infraestructure.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.aplicadorvaloraciones.GestionarPeliculasValoradas;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;
import com.hiberus.aplicadorvaloraciones.infraestructure.rest.controller.PeliculaValoradaController;

@RestController
@RequestMapping(value="/valoraciones")
public class PeliculaValoradaControllerImpl implements PeliculaValoradaController{

	@Autowired
	PeliculaRepository peliculaRepository;
	
	@Autowired
	ValoracionRepository valoracionRepository;
	
	
	@Autowired
	PeliculaValoradaKafkaService peliculaValoradaKafkaService;
	
	@PostMapping(value="/añadirValoracionAPelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void añadirValoracionAPelicula(@RequestParam Long idPelicula, @RequestParam Long idValoracion) {
		//PeliculaValoradaId peliculaValoradaId = new PeliculaValoradaId(idPelicula, idValoracion);
		GestionarPeliculasValoradas.añadirValoracionAPelicula(idPelicula,idValoracion,peliculaRepository,valoracionRepository,peliculaValoradaKafkaService);
	}

	@PostMapping(value="/eliminarValoracionDePelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion) {
		GestionarPeliculasValoradas.eliminarValoracionDePelicula(idPelicula,idValoracion,peliculaRepository,valoracionRepository,peliculaValoradaKafkaService);
	}

}
