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

import com.sebas.springboot.backend.cine.models.entidades.Actores;
import com.sebas.springboot.backend.cine.models.services.IActoresService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ActoresRestController {

	@Autowired
	private IActoresService actoresService;
	
	@GetMapping("/actores")
	public List<Actores> index(){
		return actoresService.findAll();
	}
	
	@GetMapping("/actores/{id}")
	public Actores show(@PathVariable Long id){
		return actoresService.findById(id);
	}
	
	@PostMapping("/actores")
	@ResponseStatus(HttpStatus.CREATED)
	public Actores create(@RequestBody Actores actores) {
		/////MODIFICAR por pelis???
		this.actoresService.save(actores);
		return actores;
	}
	
	@PutMapping("/actores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Actores update(@RequestBody Actores actor, @PathVariable Long id) {
		Actores currentActor = this.actoresService.findById(id);
		currentActor.SetNombre(actor.getNombre());
		////Modificar, afegir pelis?????
		this.actoresService.save(currentActor);
		return currentActor;
	}
	
	@DeleteMapping("/actoress/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Actores currentActor = this.actoresService.findById(id);
		this.actoresService.delete(currentActor);
	}
}
