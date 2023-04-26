package com.sebas.springboot.backend.cine.models.services;

import java.util.List;
import com.sebas.springboot.backend.cine.models.entidades.Tematicas;

public interface ITematicasService {
	
	public List<Tematicas> findAll();
	
	public void save(Tematicas tematica);
	
	public Tematicas findById(Long id);
	
	public void delete(Tematicas tematica);
}
