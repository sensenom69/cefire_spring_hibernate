package com.sebas.springboot.backend.cine.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sebas.springboot.backend.cine.entidades.Actores;

public interface IActores extends JpaRepository<Actores, Integer>{
	
}