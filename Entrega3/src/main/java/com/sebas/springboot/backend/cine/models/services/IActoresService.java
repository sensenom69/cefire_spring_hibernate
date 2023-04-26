package com.sebas.springboot.backend.cine.models.services;

import java.util.List;
import com.sebas.springboot.backend.cine.models.entidades.Actores;

public interface IActoresService {
	
	public List<Actores> findAll();
	
	public Actores save(Actores actor);
	
	public Actores findById(Long id);
	
	public void delete(Actores actor);
}
