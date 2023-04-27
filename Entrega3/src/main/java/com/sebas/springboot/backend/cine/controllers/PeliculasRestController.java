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
	public ResponseEntity<?> show(@PathVariable Long id){
		Peliculas pelicula = null;
		Map<String, Object> response = new HashMap<>();
		try {
			pelicula = peliculasService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Peliculas>(pelicula, HttpStatus.OK);
	}
	
	@PostMapping("/peliculas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Peliculas peliculas) {
		Peliculas peliNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			peliNew = peliculasService.save(peliculas);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El peli ha sido creado con exito");
		response.put("actor", peliNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
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
	

	@DeleteMapping("peliculas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String,Object> response = new HashMap<>();
		try {
			this.peliculasService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el id");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "La película se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
}
