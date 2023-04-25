package com.sebas.springboot.backend.cine.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sebas.springboot.backend.cine.entidades.Tematicas;

public interface ITematicas extends JpaRepository<Tematicas, Integer>{
	
}