package com.hiberus.consultadorpeliculas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.consultadorpeliculas.domain.model.PeliculaValorada;

@Repository
public interface PeliculaValoradaRepository extends JpaRepository<PeliculaValorada,Long>{

}
