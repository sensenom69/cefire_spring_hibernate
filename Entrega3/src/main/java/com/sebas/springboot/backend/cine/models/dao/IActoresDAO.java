package com.sebas.springboot.backend.cine.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sebas.springboot.backend.cine.models.entidades.Actores;

public interface IActoresDAO extends CrudRepository<Actores, Long> {

}
