package com.hiberus.consultadorpeliculas.infraestructure.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.consultadorpeliculas.ProcesarSolicitud;
import com.hiberus.consultadorpeliculas.domain.model.MejorPelicula;
import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.domain.repository.MejorPeliculaRepository;
import com.hiberus.consultadorpeliculas.domain.repository.PeliculaValoradaRepository;
import com.hiberus.consultadorpeliculas.infraestructure.rest.controller.ConsultadorPeliculasController;
import com.hiberus.consultadorpeliculas.infraestructure.rest.controller.dto.MejorPeliculaDto;
import com.hiberus.consultadorpeliculas.infraestructure.rest.controller.dto.PeliculaValoradaDto;
import com.hiberus.consultadorpeliculas.infraestructure.rest.controller.mapper.PeliculaValoradaMapper;

@RestController
@RequestMapping(value="/peliculasValoradas")
public class ConsultadorPeliculasControllerImpl implements ConsultadorPeliculasController{

	@Autowired
	PeliculaValoradaRepository peliculaValoradaRepository;
	
	@Autowired
	MejorPeliculaRepository mejorPeliculaRepository;
	
	@Autowired
	PeliculaValoradaMapper peliculaValoradaMapper;
	
	@GetMapping(value="/listarPeliculasValoradas")
	public ResponseEntity<Object> listarPeliculasValoradas() {
		List<PeliculaValorada> peliculasValoradas =  ProcesarSolicitud.listarPeliculasValoradas(peliculaValoradaRepository);
		List<PeliculaValoradaDto> peliculasValoradasDto = peliculaValoradaMapper.peliculasValoradasToPeliculasValoradasDto(peliculasValoradas);
		return ResponseEntity.status(HttpStatus.OK).body(peliculasValoradasDto);
	}

	@GetMapping(value="/obtenerPeliculaValorada/{id}")
	public ResponseEntity<Object> obtenerPeliculaValorada(@PathVariable Long id) throws JsonProcessingException {
		PeliculaValorada peliculaValorada = ProcesarSolicitud.obtenerPeliculaValorada(id,peliculaValoradaRepository);
		PeliculaValoradaDto peliculaValoradaDto = peliculaValoradaMapper.peliculaValoradaToPeliculaValoradaDto(peliculaValorada);
		return ResponseEntity.status(HttpStatus.OK).body(peliculaValoradaDto);
	}
	
	@GetMapping(value="/listarMejoresPeliculas")
	public ResponseEntity<Object> listarMejoresPeliculas() {
		List<MejorPelicula> mejoresPeliculas = ProcesarSolicitud.listarMejoresPeliculas(mejorPeliculaRepository);
		List<MejorPeliculaDto> mejoresPeliculasDto = peliculaValoradaMapper.mejoresPeliculasToMejoresPeliculasDto(mejoresPeliculas);
		return ResponseEntity.status(HttpStatus.OK).body(mejoresPeliculasDto);
	}
}
