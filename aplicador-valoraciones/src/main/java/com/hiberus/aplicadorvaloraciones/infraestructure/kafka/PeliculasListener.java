package com.hiberus.aplicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.hiberus.aplicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.aplicadorvaloraciones.domain.service.PeliculaService;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.PeliculaValue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PeliculasListener {

	@Autowired
	PeliculaService peliculaService;
	
	@StreamListener()
	public void procesarPeliculas(@Input(BinderProcessor.PELICULAS) KStream<PeliculaKey,PeliculaValue> peliculas){
		
		log.debug("[Aplicador Valoraciones] - Pelicula recibida por el topic de peliculas");
		peliculas.foreach((peliculaKey,peliculaValue)->{
			if(peliculaValue == null) {
				peliculaService.eliminar(peliculaKey.getId());
			}else {
				Pelicula pelicula = new Pelicula(
						peliculaValue.getId(),
						peliculaValue.getTitulo(),
						peliculaValue.getDescripcion(),
						peliculaValue.getCategoria().toString(),
						peliculaValue.getFechaEstreno(),
						peliculaValue.getDuracion(),
						peliculaValue.getVisualizaciones());
				peliculaService.crear(pelicula);
			}
				
		});
	}
}
