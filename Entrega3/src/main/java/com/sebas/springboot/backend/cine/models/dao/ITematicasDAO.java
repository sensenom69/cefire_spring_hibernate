package com.sebas.springboot.backend.cine.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sebas.springboot.backend.cine.models.entidades.Tematicas;

public interface ITematicasDAO extends CrudRepository<Tematicas, Long> {

}
