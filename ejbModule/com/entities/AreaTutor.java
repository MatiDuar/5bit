package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AreaTutor
 *
 */
public class AreaTutor implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAreaTutor;
	
	@Column (nullable=false, length=150)
	private String Nombre;
	
	public AreaTutor() {
		super();
	}

	public Long getIdAreaTutor() {
		return idAreaTutor;
	}

	public void setIdAreaTutor(Long idAreaTutor) {
		this.idAreaTutor = idAreaTutor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "AreaTutor [idAreaTutor=" + idAreaTutor + ", Nombre=" + Nombre + "]";
	}
	
   
}
