package com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka;

import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasKey;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasValue;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PeliculasAggregator {

	@Autowired
	Aggregator aggregator;
	
	@Autowired
	Initializer initializer;
	
	@Bean
    public Function<KStream<PeliculaValoradaKey, PeliculaValoradaValue>, KStream<PeliculasValoradasMasVistasKey, PeliculasValoradasMasVistasValue>> aggregatePeliculas() {
//        return peliculasStream -> peliculasStream
//        		.peek((k,v) -> log.info("[aggregatePeliculas) Pelicula recibida -> clave: {}, valor{}", k,v))
//        		.selectKey((k,v) -> PeliculasValoradasMasVistasKey.newBuilder().setPelicula(v.get)ç
	return null;
	}
}
