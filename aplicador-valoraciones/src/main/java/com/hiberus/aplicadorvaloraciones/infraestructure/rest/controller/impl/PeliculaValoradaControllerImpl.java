package com.hiberus.aplicadorvaloraciones.infraestructure.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.aplicadorvaloraciones.infraestructure.rest.controller.PeliculaValoradaController;
import com.hiberus.aplicadorvaloraciones.infraestructure.rest.service.PeliculaValoradaService;

@RestController
@RequestMapping(value="/valoraciones")
public class PeliculaValoradaControllerImpl implements PeliculaValoradaController{

	@Autowired
	PeliculaValoradaService peliculaValoradaService;
	
	@PostMapping(value="/añadirValoracionAPelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void añadirValoracionAPelicula(@RequestParam Long idPelicula, @RequestParam Long idValoracion) {
		peliculaValoradaService.añadirValoracionAPelicula(idPelicula,idValoracion);
	}

	@PostMapping(value="/eliminarValoracionDePelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion) {
		peliculaValoradaService.eliminarValoracionDePelicula(idPelicula,idValoracion);
	}

}
