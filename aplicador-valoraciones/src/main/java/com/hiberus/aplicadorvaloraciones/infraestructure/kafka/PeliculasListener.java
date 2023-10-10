package com.hiberus.aplicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PeliculasListener {

	@StreamListener()
	@SendTo(BinderProcessor.PELICULAS_VALORADAS)
	public KStream<PeliculaValoradaKey, PeliculaValoradaValue> procesarPeliculas(
			@Input(BinderProcessor.PELICULAS) KStream<PeliculaKey,PeliculaValue> peliculas){
		
		return null;
	}
}
