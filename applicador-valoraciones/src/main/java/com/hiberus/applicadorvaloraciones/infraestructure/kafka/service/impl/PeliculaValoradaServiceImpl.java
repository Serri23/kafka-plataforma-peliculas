package com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.mapper.PeliculaValoradaKafkaMapper;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaValoradaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeliculaValoradaServiceImpl implements PeliculaValoradaService{

	static final String TOPIC_DE_PELICULAS_VALORADAS = "peliculas_valoradas";
	
	@Autowired
	PeliculaValoradaKafkaMapper peliculaValoradaKafkaMapper;
	
	@Autowired
	private KafkaTemplate<PeliculaValoradaKey,PeliculaValoradaValue> kafkaTemplate;

	
	public void crearPeliculaValorada(PeliculaValorada peliculaValorada) {
		PeliculaValoradaKey peliculaValoradaKey = new PeliculaValoradaKey(peliculaValorada.getId());
		PeliculaValoradaValue peliculaValoradaValue = peliculaValoradaKafkaMapper.peliculaValoradaToPeliculaValoradaValue(peliculaValorada);
		kafkaTemplate.send(TOPIC_DE_PELICULAS_VALORADAS,peliculaValoradaKey,peliculaValoradaValue);
		log.info("Pelicula Valorada ["+peliculaValorada.getId()+"] enviada al topic de peliculas_valoradas");
	}
	
	public void eliminarPeliculaValorada(Long id) {
		PeliculaValoradaKey peliculaValoradaKey = new PeliculaValoradaKey(id);
		kafkaTemplate.send(TOPIC_DE_PELICULAS_VALORADAS,peliculaValoradaKey,null);
	}
}
