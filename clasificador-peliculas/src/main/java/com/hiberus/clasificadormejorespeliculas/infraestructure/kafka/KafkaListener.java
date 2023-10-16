package com.hiberus.clasificadormejorespeliculas.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.ClasificadorMejoresPeliculasService;
import com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.PeliculasService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListener {

	@Autowired
	ClasificadorMejoresPeliculasService clasificadorMejoresPeliculasService;
	
	@Autowired
	PeliculasService peliculasService;
	
	@StreamListener
	public void peliculas(@Input(BinderProcessor.PELICULAS_VALORADAS) KStream<PeliculaValoradaKey,PeliculaValoradaValue> peliculas) {
		log.debug("[Clasificador Peliculas] - Pelicula recibida por el topic de peliculas valoradas");
		peliculas.foreach((peliculaValoradaKey,peliculaValoradaValue)->{
			log.debug("[Clasificador Peliculas] - PeliculaValoradaKey: {}, PeliculaValoradaValue: {}",peliculaValoradaKey,peliculaValoradaValue);
			if(peliculaValoradaValue == null) {
				peliculasService.eliminar(peliculaValoradaKey);
			}else {
				if(clasificadorMejoresPeliculasService.clasificar(peliculaValoradaValue)) {
					log.debug("[Clasificador Peliculas] - La pelicula no ha sido clasificada");
					peliculasService.crear(peliculaValoradaKey,peliculaValoradaValue);
				}
					
				
			}
		});
	}

	
}
