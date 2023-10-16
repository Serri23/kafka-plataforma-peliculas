package com.hiberus.correctorvaloraciones.infraestructure.kafka.service.impl;



import org.springframework.stereotype.Service;

import com.hiberus.correctorvaloraciones.infraestructure.kafka.service.CorreccionValoracionService;
import com.hiberus.enviadorvaloraciones.infraestructure.kafka.avro.ValoracionValue;

@Service
public class CorreccionValoracionServiceImpl implements CorreccionValoracionService{

	@Override
	public ValoracionValue corregirValoracion(ValoracionValue valoracionValue) {
		if(valoracionValue.getComentario().length() > 50) {
			valoracionValue.setComentario(valoracionValue.getComentario().substring(0, 50));
		}
		
		if(valoracionValue.getPuntuacion() < 0 ) {
			valoracionValue.setPuntuacion(0);
		}else if(valoracionValue.getPuntuacion() > 10){
			valoracionValue.setPuntuacion(10);
		}
		
		return valoracionValue;
	}

}
