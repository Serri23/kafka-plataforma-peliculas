package com.hiberus.enviadorpeliculas.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.enviadorpeliculas.domain.Pelicula;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.avro.PeliculaKey;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.avro.PeliculaValue;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.mapper.PeliculaKafkaMapper;
import com.hiberus.enviadorpeliculas.infraestructure.rest.service.PeliculaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeliculaServiceImpl implements PeliculaService{

	static final String TOPIC_DE_PELICULAS = "peliculas";
	
	@Autowired
	PeliculaKafkaMapper peliculaKafkaMapper;
	
	@Autowired
	private KafkaTemplate<PeliculaKey,PeliculaValue> kafkaTemplate;
	
	public void crearPelicula(Pelicula pelicula) {
		if(pelicula == null) {
			log.error("Error, la pelicula es nula");
			return;
		}
		PeliculaKey peliculaKey = new PeliculaKey(pelicula.getId());
		PeliculaValue peliculaValue = peliculaKafkaMapper.peliculaToPeliculaValue(pelicula);
		kafkaTemplate.send(TOPIC_DE_PELICULAS,peliculaKey,peliculaValue);
		log.debug("[Enviador Peliculas] - PeliculaKey: {}, PeliculaValue{} enviada al topic de peliculas",peliculaKey,peliculaValue);
	}

	public void eliminarPelicula(Long id) {
		PeliculaKey peliculaKey = new PeliculaKey(id);
		kafkaTemplate.send(TOPIC_DE_PELICULAS,peliculaKey,null);
	}

}
