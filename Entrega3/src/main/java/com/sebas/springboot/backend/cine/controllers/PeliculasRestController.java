package com.sebas.springboot.backend.cine.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.backend.cine.models.entidades.Peliculas;
import com.sebas.springboot.backend.cine.models.services.IPeliculasService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class PeliculasRestController {

	@Autowired
	private IPeliculasService peliculasService;
	
	@GetMapping("/peliculas")
	public List<Peliculas> index(){
		return peliculasService.findAll();
	}
	
	@GetMapping("/peliculas/{id}")
	public Peliculas show(@PathVariable Long id){
		return peliculasService.findById(id);
	}
	
	@PostMapping("/peliculas")
	@ResponseStatus(HttpStatus.CREATED)
	public Peliculas create(@RequestBody Peliculas peliculas) {
		/////MODIFICAR por pelis???
		this.peliculasService.save(peliculas);
		return peliculas;
	}
	
	@PutMapping("/peliculas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Peliculas update(@RequestBody Peliculas pelicula, @PathVariable Long id) {
		Peliculas currentPelicula = this.peliculasService.findById(id);
		currentPelicula.setTitulo(pelicula.getTitulo());
		////Modificar, afegir pelis?????
		this.peliculasService.save(currentPelicula);
		return currentPelicula;
	}
	
	@DeleteMapping("/peliculas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Peliculas currentPelicula = this.peliculasService.findById(id);
		this.peliculasService.delete(currentPelicula);
	}
}
