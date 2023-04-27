package com.sebas.springboot.backend.cine.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.backend.cine.models.dao.ITematicasDAO;
import com.sebas.springboot.backend.cine.models.entidades.Tematicas;

@Service
public class TematicasServiceImpl implements ITematicasService {

	@Autowired
	private ITematicasDAO tematicaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Tematicas> findAll() {
		// TODO Auto-generated method stub
		return (List<Tematicas>)tematicaDao.findAll();
	}
	@Override
	@Transactional
	public Tematicas save(Tematicas tematica) {
		return tematicaDao.save(tematica);
		 
	}
	@Override
	@Transactional(readOnly = true)
	public Tematicas findById(Long id) {
		// TODO Auto-generated method stub
		return tematicaDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void delete(Tematicas tematica) {
		// TODO Auto-generated method stub
		tematicaDao.delete(tematica);
	}

}
