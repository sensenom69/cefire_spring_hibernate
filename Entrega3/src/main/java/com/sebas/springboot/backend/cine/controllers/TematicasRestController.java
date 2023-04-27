package com.sebas.springboot.backend.cine.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<?> show(@PathVariable Long id){
		Tematicas tematica = null;
		Map<String, Object> response = new HashMap<>();
		try {
			tematica = tematicasService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tematicas>(tematica, HttpStatus.OK);
	}
	
	@PostMapping("/tematicas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Tematicas tematicas) {
		Tematicas tematicaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			tematicaNew = tematicasService.save(tematicas);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El tematica ha sido creado con exito");
		response.put("tematica", tematicaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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
