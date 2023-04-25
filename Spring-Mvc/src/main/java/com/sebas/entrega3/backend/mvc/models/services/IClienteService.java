package com.sebas.entrega3.backend.mvc.models.services;

import java.util.List;
import com.sebas.entrega3.backend.mvc.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Cliente cliente);
}
