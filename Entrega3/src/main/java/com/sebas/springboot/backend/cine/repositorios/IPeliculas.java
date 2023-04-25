package com.sebas.springboot.backend.cine.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sebas.springboot.backend.cine.entidades.Peliculas;

public interface IPeliculas extends JpaRepository<Peliculas, Integer>{
	
}