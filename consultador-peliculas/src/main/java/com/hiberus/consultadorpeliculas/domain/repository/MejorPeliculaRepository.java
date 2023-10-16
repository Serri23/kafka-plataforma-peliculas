package com.hiberus.consultadorpeliculas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.consultadorpeliculas.domain.model.MejorPelicula;

@Repository
public interface MejorPeliculaRepository extends JpaRepository<MejorPelicula, Long>{

}
