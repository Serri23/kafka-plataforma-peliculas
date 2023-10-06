package com.hiberus.enviadorvaloraciones.infraestructure.rest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.enviadorvaloraciones.domain.Valoracion;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.controller.ValoracionController;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.dto.ValoracionDto;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.mapper.ValoracionMapper;
import com.hiberus.enviadorvaloraciones.infraestructure.rest.service.ValoracionService;

@RestController
@RequestMapping(value = "/valoraciones")
public class ValoracionControllerImpl implements ValoracionController{

	@Autowired
	ValoracionService valoracionService;
	
	@Autowired
	ValoracionMapper valoracionMapper;

	@PostMapping(value = "/crearValoracion")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void crearValoracion(@RequestBody ValoracionDto valoracionDto){
		Valoracion valoracion = valoracionMapper.valoracionDtoToValoracion(valoracionDto);
		valoracionService.crearValoracion(valoracion);
	}
	
	@DeleteMapping(value = "/eliminarValoracion/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminarValoracion(@PathVariable Long id){
		valoracionService.eliminarValoracion(id);
	}
}