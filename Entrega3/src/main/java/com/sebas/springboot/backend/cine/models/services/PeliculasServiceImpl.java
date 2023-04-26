package com.sebas.springboot.backend.cine.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.backend.cine.models.dao.IPeliculasDAO;
import com.sebas.springboot.backend.cine.models.entidades.Peliculas;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	@Autowired
	private IPeliculasDAO peliculasDao;
	@Override
	@Transactional(readOnly = true)
	public List<Peliculas> findAll() {
		// TODO Auto-generated method stub
		return (List<Peliculas>)peliculasDao.findAll();
	}
	@Override
	@Transactional
	public void save(Peliculas pelicula) {
		peliculasDao.save(pelicula);
		
	}
	@Override
	@Transactional(readOnly = true)
	public Peliculas findById(Long id) {
		// TODO Auto-generated method stub
		return peliculasDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void delete(Peliculas pelicula) {
		// TODO Auto-generated method stub
		peliculasDao.delete(pelicula);
	}

}
