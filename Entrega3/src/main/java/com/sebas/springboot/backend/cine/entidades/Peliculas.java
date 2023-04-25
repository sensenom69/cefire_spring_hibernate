package com.sebas.springboot.backend.cine.entidades;
// Generated 24 abr 2023 17:34:46 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Peliculas generated by hbm2java
 */
@Entity
@Table(name = "peliculas", schema = "public")
public class Peliculas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private Tematicas tematicas;
	private String titulo;
	private Set<Actores> actoreses = new HashSet<Actores>(0);

	public Peliculas() {
	}

	public Peliculas(int codigo) {
		this.codigo = codigo;
	}

	public Peliculas(int codigo, Tematicas tematicas, String titulo, Set<Actores> actoreses) {
		this.codigo = codigo;
		this.tematicas = tematicas;
		this.titulo = titulo;
		this.actoreses = actoreses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	@Column(name = "codigo", unique = true, nullable = false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tematica")
	public Tematicas getTematicas() {
		return this.tematicas;
	}

	public void setTematicas(Tematicas tematicas) {
		this.tematicas = tematicas;
	}

	@Column(name = "titulo", length = 50)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "peliculas_actores", schema = "public", joinColumns = {
			@JoinColumn(name = "pelicula", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "actor", nullable = false, updatable = false) })
	public Set<Actores> getActoreses() {
		return this.actoreses;
	}

	public void setActoreses(Set<Actores> actoreses) {
		this.actoreses = actoreses;
	}

}
