package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EstadoAsistencia
 *
 */
@Entity
public class EstadoAsistencia implements Serializable {

	public EstadoAsistencia() {
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
		return "EstadoAsistencia [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
   
}
