package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoAsignatura
 *
 */
public class TipoAsignatura implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public TipoAsignatura() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_ASIGNATURA" )
	@SequenceGenerator(name = "SEQ_TIPO_ASIGNATURA", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable=false)
	private Boolean activo;
	
	@Column(nullable=false)
	private String nombre;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoAsignatura [id=" + id + ", activo=" + activo + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
	

	
   
}
