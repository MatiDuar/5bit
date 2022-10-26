package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estudiante
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Estudiante extends Usuario implements Serializable {
	
	public Estudiante() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
	@ManyToOne(optional=false)
	private Generacion generacion;


	public Generacion getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Generacion generacion) {
		this.generacion = generacion;
	}

	
	
	
   
}
