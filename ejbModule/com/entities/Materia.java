package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


public class Materia implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Materia() {
		super();
	} 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATERIA" )
	@SequenceGenerator(name = "SEQ_MATERIA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column (nullable=false, length=150,unique=true)
	private String nombre;
	
	@ManyToMany( mappedBy="materias")
	private List <Carrera> carreras;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
   
}
