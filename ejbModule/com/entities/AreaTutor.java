package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AreaTutor
 *
 */
public class AreaTutor implements Serializable {

	
private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AREA_TUTOR" )
	@SequenceGenerator(name = "SEQ_AREA_TUTOR", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column (nullable=false, length=150,unique=true)
	private String Nombre;
	
	public AreaTutor() {
		super();
	}

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

	@Override
	public String toString() {
		return "AreaTutor [id=" + id + ", Nombre=" + Nombre + "]";
	}
	
   
}
