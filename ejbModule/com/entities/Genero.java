package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Genero
 *
 */
@Entity
public class Genero implements Serializable {
	
	public Genero() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String nombre;
	
	@Column(nullable=false)
	private Boolean activo;

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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
	}
	
	
	
	
   
}
