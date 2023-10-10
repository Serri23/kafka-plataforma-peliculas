package com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;

public class PeliculaValoradaKafkaServiceImpl implements PeliculaValoradaKafkaService{

	static final String TOPIC_DE_PELICULAS_VALORADAS = "peliculasValoradas";
	
	@Autowired
	private KafkaTemplate<PeliculaValoradaKey,PeliculaValoradaValue> kafkaTemplate;
	
	public void enviarPeliculaValorada(PeliculaValorada peliculaValorada) {
		PeliculaValoradaKey peliculaValoradaKey = new PeliculaValoradaKey();
		peliculaValoradaKey.setId(peliculaValorada.getId());
		PeliculaValoradaValue peliculaValoradaValue = new PeliculaValoradaValue();
		//peliculaValoradaValue.setPelicula(peliculaValorada.getPelicula());
		
		
	}

}
