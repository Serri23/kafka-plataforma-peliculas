package com.hiberus.agrupadorpeliculas.infraestructure.kafka;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.Pelicula;
import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.PeliculaPorCategoriaKey;
import com.hiberus.agrupadorpeliculas.infraestructure.kafka.avro.PeliculaPorCategoriaValue;
import com.hiberus.applicadorvaloraciones.infraestructure.kafka.avro.PeliculaValoradaValue;

@Component
public class Aggregator implements org.apache.kafka.streams.kstream.Aggregator<PeliculaPorCategoriaKey, PeliculaValoradaValue, PeliculaPorCategoriaValue>{

	@Override
	public PeliculaPorCategoriaValue apply(PeliculaPorCategoriaKey peliculasAgregadasKey, PeliculaValoradaValue peliculaValue,
			PeliculaPorCategoriaValue peliculasAgregadasValue) {
		peliculasAgregadasValue = PeliculaPorCategoriaValue.newBuilder()
                .setPeliculas(peliculasAgregadasValue.getPeliculas()
                        .stream()
                        .filter(c -> peliculaValue.getId() != (c.getId()))
                        .collect(Collectors.toList())).build();

		peliculasAgregadasValue.getPeliculas().add(createPelicula(peliculaValue));

        return peliculasAgregadasValue;
	}

	private Pelicula createPelicula(PeliculaValoradaValue peliculaValue) {
		return Pelicula.newBuilder()
                .setId(peliculaValue.getId())
                .setTitulo(peliculaValue.getTitulo())
                .setDescripcion(peliculaValue.getDescripcion())
                .setFechaEstreno(peliculaValue.getFechaEstreno())
                .setDuracion(peliculaValue.getDuracion())
                .setVisualizaciones(peliculaValue.getVisualizaciones())
                .setValoraciones(peliculaValue.getValoraciones())
                .build();
	}

}
