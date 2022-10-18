package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoTutor
 *
 */
@Entity
public class TipoTutor implements Serializable {

	public TipoTutor() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String nombre;

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

	@Override
	public String toString() {
		return "TipoTutor [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
   
}
