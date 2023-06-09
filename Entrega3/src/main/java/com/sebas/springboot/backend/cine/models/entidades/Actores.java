package com.sebas.springboot.backend.cine.models.entidades;
// Generated 24 abr 2023 17:34:46 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Actores generated by hbm2java
 */
@Entity
@Table(name = "actores", schema = "public")
public class Actores implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "codigo", unique = true, nullable = false)
	private int codigo;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "peliculas_actores", schema = "public", joinColumns = {
			@JoinColumn(name = "actor", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "pelicula", nullable = false, updatable = false) })
	private Set<Peliculas> peliculases = new HashSet<Peliculas>(0);

	public Actores() {
	}

	public Actores(int codigo) {
		this.codigo = codigo;
	}

	public Actores(int codigo, String nombre, Set<Peliculas> peliculases) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.peliculases = peliculases;
	}

	
	public int getCodigo() {
		return this.codigo;
	}

	public void SetCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void SetNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnoreProperties("actoreses")
	public Set<Peliculas> getPeliculases() {
		return this.peliculases;
	}

	public void SetPeliculases(Set<Peliculas> peliculases) {
		this.peliculases = peliculases;
	}

}
