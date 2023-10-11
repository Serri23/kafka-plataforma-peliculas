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
	
	public static void añadirValoracionAPelicula(Long idPelicula,Long idValoracion,PeliculaRepository peliculaRepository, ValoracionRepository valoracionRepository, PeliculaValoradaRepository peliculaValoradaRepository, PeliculaValoradaKafkaService peliculaValoradaKafkaService) {
		
		if(!valoracionRepository.existsById(idValoracion)) {
			Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
			if(!peliculaValoradaRepository.existsById(idPelicula)) {
				ArrayList<Valoracion> valoraciones = new ArrayList<>();
				valoraciones.add(valoracion);
				Pelicula pelicula = peliculaRepository.findById(idPelicula).get();
				PeliculaValorada peliculaValorada = new PeliculaValorada(
						pelicula.getId(),
						pelicula.getTitulo(),
						pelicula.getDescripcion(),
						pelicula.getCategoria(),
						pelicula.getFechaEstreno(),
						pelicula.getDuracion(),
						pelicula.getVisualizaciones(),
						valoraciones);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
			}else {
				PeliculaValorada peliculaValorada = peliculaValoradaRepository.findById(idPelicula).get();
				peliculaValorada.getValoraciones().add(valoracion);
				peliculaValoradaRepository.save(peliculaValorada);
				peliculaValoradaKafkaService.enviarPeliculaValorada(peliculaValorada);
			}
//			else {
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
