package com.sebas.springboot.backend.cine.models.services;

import java.util.List;
import com.sebas.springboot.backend.cine.models.entidades.Peliculas;

public interface IPeliculasService {
	
	public List<Peliculas> findAll();
	
	public Peliculas save(Peliculas pelicula);
	
	public Peliculas findById(Long id);
	
	public void delete(Peliculas pelicula);
}
