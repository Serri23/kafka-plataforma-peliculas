package com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.impl;

import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.Valoracion;
import com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.ClasificadorMejoresPeliculasService;

@Service
public class ClasificadorMejoresPeliculasServiceImpl implements ClasificadorMejoresPeliculasService{

	
	public boolean clasificar(PeliculaValoradaValue peliculaValoradaValue) {
		boolean resultado = false;
		
		float puntuacion_media_valoraciones;
	    float puntuacion_total_valoraciones = 0;
	    
		for(Valoracion valoracion : peliculaValoradaValue.getValoraciones()) {
			puntuacion_total_valoraciones += valoracion.getPuntuacion();
		}
		
		puntuacion_media_valoraciones = puntuacion_total_valoraciones/peliculaValoradaValue.getValoraciones().size();
		
		if(puntuacion_media_valoraciones > 7 && peliculaValoradaValue.getVisualizaciones() > 1000000)
			resultado = true;
	
		return resultado;
	}

}
