package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Materia
 *
 */
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
	private String Nombre;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
   
}
