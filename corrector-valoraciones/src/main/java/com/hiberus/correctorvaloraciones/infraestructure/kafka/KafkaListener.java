package com.hiberus.correctorvaloraciones.infraestructure.kafka;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.hiberus.correctorvaloraciones.infraestructure.kafka.service.CorreccionValoracionService;
import com.hiberus.correctorvaloraciones.infraestructure.kafka.service.ValoracionCorregidaService;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListener {
	
	@Autowired
	CorreccionValoracionService correcionValoracionService;
	
	@Autowired
	ValoracionCorregidaService valoracionCorregidaService;
	
	@StreamListener
	public void valoraciones(@Input(BinderProcessor.VALORACIONES) KStream<ValoracionKey,ValoracionValue> valoraciones){
		log.debug("[Corrector Valoraciones] - Valoracion recibida por el topic de valoraciones");
		valoraciones.foreach((valoracionKey,valoracionValue)->{
			log.debug("[Corrector Valoraciones] - ValoracionKey: {}, ValoracionValue: {}",valoracionKey,valoracionValue);
			if(valoracionValue == null) {
				valoracionCorregidaService.eliminar(valoracionKey);
			}else {
				valoracionValue = correcionValoracionService.corregirValoracion(valoracionValue);
				valoracionCorregidaService.crear(valoracionKey,valoracionValue);
			}
		});
		
		
	}

}
