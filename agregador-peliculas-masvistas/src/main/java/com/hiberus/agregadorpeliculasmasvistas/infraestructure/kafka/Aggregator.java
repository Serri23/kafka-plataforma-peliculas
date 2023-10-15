package com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.Pelicula;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculaValoradaValue;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasKey;
import com.hiberus.agregadorpeliculasmasvistas.infraestructure.kafka.avro.PeliculasValoradasMasVistasValue;

@Component
public class Aggregator implements org.apache.kafka.streams.kstream.Aggregator<PeliculasValoradasMasVistasKey, PeliculaValoradaValue, PeliculasValoradasMasVistasValue>{

	@Override
	public PeliculasValoradasMasVistasValue apply(PeliculasValoradasMasVistasKey peliculasAgregadasKey, PeliculaValoradaValue peliculaValue,
			PeliculasValoradasMasVistasValue peliculasAgregadasValue) {
		peliculasAgregadasValue = PeliculasValoradasMasVistasValue.newBuilder()
                .setPeliculas(peliculasAgregadasValue.getPeliculas()
                        .stream()
                        .filter(c -> peliculaValue.getId() != (c.getId()) && peliculaValue.getVisualizaciones() > 1000000)
                        .collect(Collectors.toList())).build();

		peliculasAgregadasValue.getPeliculas().add(createPelicula(peliculaValue));

        return peliculasAgregadasValue;
	}

	private Pelicula createPelicula(PeliculaValoradaValue peliculaValue) {
		return Pelicula.newBuilder()
                .setId(peliculaValue.getId())
                .setTitulo(peliculaValue.getTitulo())
                .setDescripcion(peliculaValue.getDescripcion())
                .setCategoria(peliculaValue.getCategoria())
                .setFechaEstreno(peliculaValue.getFechaEstreno())
                .setDuracion(peliculaValue.getDuracion())
                .build();
	}

}
