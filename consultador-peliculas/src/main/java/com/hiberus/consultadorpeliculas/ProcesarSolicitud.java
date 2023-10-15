package com.hiberus.consultadorpeliculas;

import java.util.List;

import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.domain.repository.PeliculaValoradaRepository;

public class ProcesarSolicitud {

	
	public ProcesarSolicitud() {}

	public static List<PeliculaValorada> listarPeliculasValoradas(
			PeliculaValoradaRepository peliculaValoradaRepository) {
		return peliculaValoradaRepository.findAll();
	}

	public static PeliculaValorada obtenerPeliculaValorada(Long idPeliculaValorada,
			PeliculaValoradaRepository peliculaValoradaRepository) {
		return peliculaValoradaRepository.findById(idPeliculaValorada).get();
	}
	
}
