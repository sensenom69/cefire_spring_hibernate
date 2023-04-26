package com.sebas.springboot.backend.cine.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sebas.springboot.backend.cine.models.entidades.Peliculas;

public interface IPeliculasDAO extends CrudRepository<Peliculas, Long> {

}
