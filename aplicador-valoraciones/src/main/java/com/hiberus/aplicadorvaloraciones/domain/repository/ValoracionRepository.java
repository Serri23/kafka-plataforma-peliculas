package com.hiberus.aplicadorvaloraciones.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.aplicadorvaloraciones.domain.model.Valoracion;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long>{

}
