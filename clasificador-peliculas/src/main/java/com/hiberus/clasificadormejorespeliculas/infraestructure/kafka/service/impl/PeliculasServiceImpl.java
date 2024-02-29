package com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.clasificadormejorespeliculas.infraestructure.kafka.service.PeliculasService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeliculasServiceImpl implements PeliculasService{

	static final String TOPIC_DE_PELICULAS_MEJORES_PELICULAS = "mejores_peliculas";
	
	@Autowired
	private KafkaTemplate<PeliculaValoradaKey,PeliculaValoradaValue> kafkaTemplate;
	
	public void crear(PeliculaValoradaKey peliculaValoradaKey, PeliculaValoradaValue peliculaValoradaValue) {
		kafkaTemplate.send(TOPIC_DE_PELICULAS_MEJORES_PELICULAS,peliculaValoradaKey,peliculaValoradaValue);
		log.debug("[Clasificador mejores peliculas] - peliculaKey; {} , peliculaValue {} enviada al topic de mejores peliculas",peliculaValoradaKey,peliculaValoradaValue);
	}

	@Override
	public void eliminar(PeliculaValoradaKey peliculaValoradaKey) {
		kafkaTemplate.send(TOPIC_DE_PELICULAS_MEJORES_PELICULAS,peliculaValoradaKey,null);

	}

}
