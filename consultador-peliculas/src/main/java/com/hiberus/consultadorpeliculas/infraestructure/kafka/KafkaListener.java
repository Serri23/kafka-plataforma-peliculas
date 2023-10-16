package com.hiberus.consultadorpeliculas.infraestructure.kafka;



import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;
import com.hiberus.consultadorpeliculas.infraestructure.kafka.service.PeliculaValoradaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaListener {

	@Autowired
	PeliculaValoradaService peliculaValoradaService;
	
	@StreamListener
	public void peliculasValoradas(@Input(BinderProcessor.PELICULAS_VALORADAS) KStream<PeliculaValoradaKey,PeliculaValoradaValue> peliculasValoradas) {
		log.debug("[Consultador Peliculas] - Pelicula valorada recibida por el topic de peliculas valoradas");
		
		peliculasValoradas.foreach((peliculaValoradaKey,peliculaValoradaValue)->{
			if(peliculaValoradaValue == null) {
				peliculaValoradaService.eliminarPeliculaValorada(peliculaValoradaKey.getId());
			}else {
				PeliculaValorada peliculaValorada = new PeliculaValorada(
						peliculaValoradaValue.getId(),
						peliculaValoradaValue.getTitulo(),
						peliculaValoradaValue.getDescripcion(),
						peliculaValoradaValue.getCategoria(),
						peliculaValoradaValue.getFechaEstreno(),
						peliculaValoradaValue.getDuracion(),
						peliculaValoradaValue.getVisualizaciones(),
						peliculaValoradaValue.getValoraciones());
				peliculaValoradaService.crearPeliculaValorada(peliculaValorada);
			}
		});
	}
}
