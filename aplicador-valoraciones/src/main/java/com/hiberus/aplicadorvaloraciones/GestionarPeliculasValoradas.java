package com.hiberus.aplicadorvaloraciones;

import java.util.ArrayList;
import java.util.List;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValoradaId;
import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.PeliculaValoradaRepository;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;

public class GestionarPeliculasValoradas{

	private GestionarPeliculasValoradas() {}
	
	public static void añadirValoracionAPelicula(PeliculaValoradaId peliculaValoradaId,PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaRepository peliculaValoradaRepository, PeliculaValoradaKafkaService peliculaValoradaKafkaService) {
		
		if(!valoracionRepository.existsById(peliculaValoradaId.getIdValoracion())) {
			Valoracion valoracion = valoracionRepository.findById(peliculaValoradaId.getIdValoracion()).get();
			if(!peliculaValoradaRepository.existsById(peliculaValoradaId.getIdPelicula())) {
				List<Valoracion> valoraciones = new ArrayList<>();
				valoraciones.add(valoracion);
				Pelicula pelicula = peliculaRepository.findById(peliculaValoradaId.getIdPelicula()).get();
				PeliculaValorada peliculaValorada = new PeliculaValorada(peliculaValoradaId,pelicula,valoracion);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
			}
//			}else {
//				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(peliculaValoradaId.getIdPelicula()).get();
//				peliculaValorada.getValoraciones().add(valoracion);
//				peliculaValoradaRepository.save(peliculaValorada);
//				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
//			}
		}
		
	}

	public static void eliminarValoracionDePelicula(Long idPelicula, Long idValoracion, PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaRepository peliculaValoradaRepository, PeliculaValoradaKafkaService peliculaValoradaKafkaService) {
		
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
