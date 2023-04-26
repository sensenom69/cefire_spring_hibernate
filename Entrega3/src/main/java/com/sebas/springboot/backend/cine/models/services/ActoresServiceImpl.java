package com.sebas.springboot.backend.cine.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.backend.cine.models.dao.IActoresDAO;
import com.sebas.springboot.backend.cine.models.entidades.Actores;

@Service
public class ActoresServiceImpl implements IActoresService {

	@Autowired
	private IActoresDAO actoresDao;
	@Override
	@Transactional(readOnly = true)
	public List<Actores> findAll() {
		// TODO Auto-generated method stub
		return (List<Actores>)actoresDao.findAll();
	}
	@Override
	@Transactional
	public void save(Actores actor) {
		actoresDao.save(actor);
		
	}
	@Override
	@Transactional(readOnly = true)
	public Actores findById(Long id) {
		// TODO Auto-generated method stub
		return actoresDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void delete(Actores actor) {
		// TODO Auto-generated method stub
		actoresDao.delete(actor);
	}

}
