package com.hiberus.aplicadorvaloraciones.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.aplicadorvaloraciones.domain.model.PeliculaValorada;

@Repository
public interface PeliculaValoradaRepository extends JpaRepository<PeliculaValorada, Long>{

}
