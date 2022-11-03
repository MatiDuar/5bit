package com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Funcionalidad
 *
 */
public class Funcionalidad implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Funcionalidad() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONALIDADES" )
	@SequenceGenerator(name = "SEQ_FUNCIONALIDADES", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50)
	String nombre;
	
	@Column(nullable=false,length=150)
	String descripcion;
	public Long getId() {
		return id;
	}
	
	@ManyToMany( mappedBy="funcionalidades")
	 private Set <Rol> roles;

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Funcionalidad [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
   
}
