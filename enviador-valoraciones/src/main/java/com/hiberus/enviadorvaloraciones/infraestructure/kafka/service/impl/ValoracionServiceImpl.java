package com.hiberus.enviadorvaloraciones.infraestructure.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hiberus.enviadorvaloraciones.domain.Valoracion;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionKey;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.mapper.ValoracionKafkaMapper;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.service.ValoracionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValoracionServiceImpl implements ValoracionService{
	
	static final String TOPIC_DE_VALORACIONES = "valoraciones";
	
	@Autowired
	ValoracionKafkaMapper valoracionKafkaMapper;
	
	@Autowired
	private KafkaTemplate<ValoracionKey,ValoracionValue> kafkaTemplate;
	
	@Override
	public void crearValoracion(Valoracion valoracion) {
		ValoracionKey valoracionKey = new ValoracionKey(valoracion.getId());
		ValoracionValue valoracionValue = valoracionKafkaMapper.valoracionToValoracionValue(valoracion);
		kafkaTemplate.send(TOPIC_DE_VALORACIONES,valoracionKey,valoracionValue);
		log.debug("[Enviador Valoraciones] - ValoracionKey: {}, ValoracionValue: {} enviada al topic de valoraciones",valoracionKey,valoracionValue);
	}

	@Override
	public void eliminarValoracion(Long id) {
		ValoracionKey valoracionKey = new ValoracionKey(id);
		kafkaTemplate.send(TOPIC_DE_VALORACIONES,valoracionKey,null);
	}
}
