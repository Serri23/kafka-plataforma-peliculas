package com.hiberus.applicadorvaloraciones.infraestructure.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.applicadorvaloraciones.infraestructure.ProcesarSolicitud;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaService;
import com.hiberus.applicadorvaloraciones.infraestructure.rest.controller.AplicadorValoracionesController;

@RestController
@RequestMapping(value="/valoraciones")
public class AplicadorValoracionesControllerImpl implements AplicadorValoracionesController{

	@Autowired
	PeliculaRepository peliculaRepository;
	
	@Autowired
	ValoracionRepository valoracionRepository;
	
	@Autowired
	PeliculaValoradaService peliculaValoradaService;
	
	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	@PostMapping(value="/añadirValoracionAPelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void añadirValoracionAPelicula(@RequestParam Long idPelicula, @RequestParam Long idValoracion) {
		ProcesarSolicitud.añadirValoracionAPelicula(idPelicula,idValoracion,peliculaRepository,valoracionRepository,peliculaValoradaRepository,peliculaValoradaService);
	}

//	@PostMapping(value="/eliminarValoracionDePelicula")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion) {
//		ProcesarSolicitud.eliminarValoracionDePelicula(idPelicula,idValoracion,peliculaRepository,valoracionRepository,peliculaValoradaRepository,peliculaValoradaService);
//	}

}
