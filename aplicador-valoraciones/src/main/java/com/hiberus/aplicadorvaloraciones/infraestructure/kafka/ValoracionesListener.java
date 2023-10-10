package com.hiberus.aplicadorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;
import com.hiberus.aplicadorvaloraciones.domain.repository.ValoracionRepository;
import com.hiberus.aplicadorvaloraciones.domain.service.ValoracionService;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.aplicadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ValoracionesListener {
	@Autowired
	ValoracionService valoracionService;
	
	@StreamListener
	public void procesarValoraciones(@Input(BinderProcessor.VALORACIONES) KStream<ValoracionKey,ValoracionValue> valoraciones) {
		
		log.debug("[AplicadorValoraciones] - Valoracion recibida por el topic valoraciones");
		valoraciones.foreach((valoracionKey,valoracionValue) ->{
			if((valoracionValue == null)) {
				valoracionService.eliminar(valoracionKey.getId());
			}else {
				Valoracion valoracion = new Valoracion(valoracionKey.getId(),valoracionValue.getIdPelicula(),valoracionValue.getPuntuacion(),valoracionValue.getComentario());
				valoracionService.crear(valoracion);
			}
		});
	}

}
