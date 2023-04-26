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

import com.sebas.springboot.backend.cine.models.entidades.Tematicas;
import com.sebas.springboot.backend.cine.models.services.ITematicasService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class TematicasRestController {

	@Autowired
	private ITematicasService tematicasService;
	
	@GetMapping("/tematicas")
	public List<Tematicas> index(){
		return tematicasService.findAll();
	}
	
	@GetMapping("/tematicas/{id}")
	public Tematicas show(@PathVariable Long id){
		return tematicasService.findById(id);
	}
	
	@PostMapping("/tematicas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tematicas create(@RequestBody Tematicas tematicas) {
		/////MODIFICAR por pelis???
		this.tematicasService.save(tematicas);
		return tematicas;
	}
	
	@PutMapping("/tematicas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tematicas update(@RequestBody Tematicas tematica, @PathVariable Long id) {
		Tematicas currentPelicula = this.tematicasService.findById(id);
		currentPelicula.setDescripcion(tematica.getDescripcion());
		////Modificar, afegir pelis?????
		this.tematicasService.save(currentPelicula);
		return currentPelicula;
	}
	
	@DeleteMapping("/tematicas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Tematicas currentPelicula = this.tematicasService.findById(id);
		this.tematicasService.delete(currentPelicula);
	}
}
