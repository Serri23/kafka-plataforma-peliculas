package com.hiberus.applicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.hiberus.applicadorvaloraciones.domain.model.Pelicula;
import com.hiberus.applicadorvaloraciones.domain.model.ValoracionDomain;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.PeliculaService;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.service.ValoracionService;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.avro.PeliculaKey;
import com.hiberus.enviadorpeliculas.infraestructure.kafka.avro.PeliculaValue;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaListener {

	@Autowired
	PeliculaService peliculaService;
	
	@Autowired
	ValoracionService valoracionService;
	
	
	@StreamListener
	public void peliculas(@Input(BinderProcessor.PELICULAS) KStream<PeliculaKey,PeliculaValue> peliculas){
		
		log.debug("[Aplicador Valoraciones] - Pelicula recibida por el topic de peliculas");
		peliculas.foreach((peliculaKey,peliculaValue)->{
			if(peliculaValue == null) {
				peliculaService.eliminar(peliculaKey.getId());
			}else {
				Pelicula pelicula = new Pelicula(
						peliculaValue.getId(),
						peliculaValue.getTitulo(),
						peliculaValue.getDescripcion(),
						peliculaValue.getCategoria(),
						peliculaValue.getFechaEstreno(),
						peliculaValue.getDuracion(),
						peliculaValue.getVisualizaciones());
				peliculaService.crear(pelicula);
			}
				
		});
	}
	
	@StreamListener
	public void valoraciones(@Input(BinderProcessor.VALORACIONES) KStream<ValoracionKey,ValoracionValue> valoraciones) {
		
		log.debug("[AplicadorValoraciones] - Valoracion recibida por el topic valoraciones");
		valoraciones.foreach((valoracionKey,valoracionValue) ->{
			if((valoracionValue == null)) {
				valoracionService.eliminar(valoracionKey.getId());
			}else {
				ValoracionDomain valoracion = new ValoracionDomain(valoracionValue.getId(),valoracionValue.getIdPelicula(),valoracionValue.getPuntuacion(),valoracionValue.getComentario());
				valoracionService.crear(valoracion);
			}
		});
	}
}
