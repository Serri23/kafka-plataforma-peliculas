package com.hiberus.agrupadorpeliculas.infraestructure.kafka;

import java.util.function.Function;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.PeliculaPorCategoriaKey;
import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.PeliculaPorCategoriaValue;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaKey;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PeliculasAggregator {

	@Autowired
	Aggregator aggregator;
	
	@Autowired
	Initializer initializer;
	
	@Bean
    public Function<KStream<PeliculaValoradaKey, PeliculaValoradaValue>, KStream<PeliculaPorCategoriaKey, PeliculaPorCategoriaValue>> aggregatePeliculas() {
		return peliculasStream -> peliculasStream
				.peek((k,v) -> log.debug("[Agregador Peliculas] - Pelicula reicibida -> clave: {}, valor: {}",k,v))
				.selectKey((k,v) -> PeliculaPorCategoriaKey.newBuilder().setCategoria(v.getCategoria()).build())
				.groupByKey()
				.aggregate(initializer,aggregator,Named.as("PELICULAS_POR_CATEGORIA"),Materialized.as("PELICULAS_POR_CATEGORIA"))
				.toStream()
				.peek((k,v) -> log.debug("[Agregador Peliculas] - Peliculas agrupadas -> clave: {}, valor: {}",k,v));
	}
}
