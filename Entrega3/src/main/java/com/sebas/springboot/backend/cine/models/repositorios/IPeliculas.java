package com.sebas.springboot.backend.cine.models.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.backend.cine.models.entidades.Peliculas;

public interface IPeliculas extends JpaRepository<Peliculas, Integer>{
	
}