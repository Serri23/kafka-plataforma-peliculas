package com.hiberus.aplicadorvaloraciones;

import java.util.ArrayList;
import java.util.List;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;

public class GestionarPeliculasValoradas{

	private GestionarPeliculasValoradas() {}
	
	public static void añadirValoracionAPelicula(Long idPelicula,Long idValoracion,PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaKafkaService peliculaValoradaKafkaService) {
		
		if(!valoracionRepository.existsById(idValoracion)) {
			Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
			if(peliculaRepository.existsById(idPelicula)) {
				ArrayList<Valoracion> valoraciones = new ArrayList<>();
				valoraciones.add(valoracion);
				Pelicula pelicula = peliculaRepository.findById(idPelicula).get();
				peliculaRepository.deleteById(idPelicula);
				pelicula.getValoraciones().add(valoracion);
				peliculaRepository.save(pelicula);
				peliculaValoradaKafkaService.enviarPeliculaValorada(pelicula);
			}
		}
		
	}

	public static void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion, PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaKafkaService peliculaValoradaKafkaService) {
		
//		if(valoracionRepository.existsById(idValoracion)) {
//			Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
//			PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(idPelicula).get();
//			peliculaValoradaRepository.delete(peliculaValorada);
//			peliculaValorada.getValoraciones().remove(valoracion);
//			peliculaValoradaRepository.save(peliculaValorada);
//			peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
//		}
		
	}
}
