package com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaKafkaService;

@Service
public class PeliculaValoradaKafkaServiceImpl implements PeliculaValoradaKafkaService{

	static final String TOPIC_DE_PELICULAS_VALORADAS = "peliculas_valoradas";
	
	@Autowired
	private KafkaTemplate<PeliculaValoradaKey,PeliculaValoradaValue> kafkaTemplate;
	
	public void crearPeliculaValorada(Pelicula peliculaValorada) {
		PeliculaValoradaKey peliculaValoradaKey = new PeliculaValoradaKey();
		peliculaValoradaKey.setId(peliculaValorada.getId());
		PeliculaValoradaValue peliculaValoradaValue = new PeliculaValoradaValue();
		
		kafkaTemplate.send(TOPIC_DE_PELICULAS_VALORADAS,peliculaValoradaKey,peliculaValoradaValue);
		
	}

}
