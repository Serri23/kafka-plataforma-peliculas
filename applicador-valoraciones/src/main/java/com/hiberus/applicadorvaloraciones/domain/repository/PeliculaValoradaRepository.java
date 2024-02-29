package com.hiberus.applicadorvaloraciones.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.applicadorvaloraciones.domain.model.PeliculaValorada;

@Repository
public interface PeliculaValoradaRepository extends JpaRepository<PeliculaValorada, Long>{

}
