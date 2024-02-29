package com.hiberus.correctorvaloraciones.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {
	
	String VALORACIONES = "valoraciones";
	
	@Input(VALORACIONES)
	KStream<?,?> valoraciones();
	
}
