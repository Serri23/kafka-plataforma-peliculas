package com.hiberus.enviadorpeliculas.infraestructure.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.enviadorpeliculas.domain.Pelicula;
import com.hiberus.enviadorpeliculas.infraestructure.rest.controller.PeliculaController;
import com.hiberus.enviadorpeliculas.infraestructure.rest.dto.PeliculaDto;
import com.hiberus.enviadorpeliculas.infraestructure.rest.mapper.PeliculaMapper;
import com.hiberus.enviadorpeliculas.infraestructure.rest.service.PeliculaService;

@RestController
@RequestMapping(value = "/peliculas")
public class PeliculaControllerImpl implements PeliculaController{

	@Autowired
	PeliculaService peliculaService;
	
	@Autowired
	PeliculaMapper peliculaMapper;
	
	@PostMapping(value = "/crearPelicula")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void crearPelicula(@RequestBody PeliculaDto peliculaDto) {
		Pelicula pelicula = peliculaMapper.peliculaDtoToPelicula(peliculaDto);
		peliculaService.crearPelicula(pelicula);
	}

	@PostMapping(value = "/eliminarPelicula/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminarPelicula(@PathVariable Long id) {
		peliculaService.eliminarPelicula(id);
	}

}
