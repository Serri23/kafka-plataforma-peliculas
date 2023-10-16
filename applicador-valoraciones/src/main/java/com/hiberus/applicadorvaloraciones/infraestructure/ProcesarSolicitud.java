package com.hiberus.applicadorvaloraciones.infraestructure;


import com.hiberus.applicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.domain.model.ValoracionDomain;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.applicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaService;


public class ProcesarSolicitud {
	
	public ProcesarSolicitud() {}

	public static void añadirValoracionAPelicula(Long idPelicula,Long idValoracion,PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaRepository peliculaValoradaRepository, PeliculaValoradaService peliculaValoradaService) {
		
		ValoracionDomain valoracion = valoracionRepository.findById(idValoracion).get();
		Pelicula pelicula = peliculaRepository.findById(idPelicula).get();
		if(valoracion.getIdPelicula() == pelicula.getId()) {
			if(peliculaValoradaRepository.existsById(idPelicula)) {
				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(idPelicula).get();
				if(!peliculaValorada.getValoraciones().contains(valoracion)) {
					peliculaValoradaRepository.deleteById(idPelicula);
					peliculaValorada.getValoraciones().add(valoracion);
					peliculaValoradaRepository.save(peliculaValorada);
					peliculaValoradaService.crearPeliculaValorada(peliculaValorada);
				}
			}else {
				PeliculaValorada peliculaValorada = new PeliculaValorada(pelicula);
				peliculaValorada.getValoraciones().add(valoracion);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaService.crearPeliculaValorada(peliculaValorada);
			}
				
		}
	}

}
