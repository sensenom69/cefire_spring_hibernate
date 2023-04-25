package com.sebas.entrega3.backend.mvc.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sebas.entrega3.backend.mvc.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {

}
