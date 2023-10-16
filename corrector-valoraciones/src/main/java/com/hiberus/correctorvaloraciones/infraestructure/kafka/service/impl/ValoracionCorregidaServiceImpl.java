package com.hiberus.correctorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.correctorvaloraciones.infraestructure.kafka.service.ValoracionCorregidaService;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValoracionCorregidaServiceImpl implements ValoracionCorregidaService{

	static final String TOPIC_DE_VALORACIONES_CORREGIDAS = "valoraciones_corregidas";
	
	@Autowired
	private KafkaTemplate<ValoracionKey,ValoracionValue> kafkaTemplate;
	
	public void crear(ValoracionKey valoracionKey, ValoracionValue valoracionValue) {
		kafkaTemplate.send(TOPIC_DE_VALORACIONES_CORREGIDAS,valoracionKey,valoracionValue);
		log.debug("[Corrector Valoraciones] - valoracionKey; {} , valoracionValue {} enviada al topic de valoraciones_corregidas",valoracionValue,valoracionKey);
	}

	public void eliminar(ValoracionKey valoracionKey) {
		kafkaTemplate.send(TOPIC_DE_VALORACIONES_CORREGIDAS,valoracionKey,null);
	}

}
