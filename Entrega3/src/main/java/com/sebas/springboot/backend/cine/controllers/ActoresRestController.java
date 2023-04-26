package com.sebas.springboot.backend.cine.controllers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> show(@PathVariable Long id){
		Actores actor = null;
		Map<String, Object> response = new HashMap<>();
		try {
			actor = actoresService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Actores>(actor, HttpStatus.OK);
	}
	
	@PostMapping("/actores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Actores actores) {
		Actores actorNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			actorNew = actoresService.save(actores);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El actor ha sido creado con exito");
		response.put("actor", actorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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
