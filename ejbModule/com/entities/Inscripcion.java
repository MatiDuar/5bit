package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Inscripciones
 *
 */
public class Inscripcion implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSCRIPCION" )
	@SequenceGenerator(name = "SEQ_INSCRIPCION", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable=false)
	private Boolean activo;
	
	@ManyToOne
	private Estudiante estudiante;
	
	@ManyToOne
	private Carrera carrera;
	
	@ManyToOne
	private Escolaridad escolaridad;
	
	
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}


	private static final long serialVersionUID = 1L;	
	public Inscripcion() {
		super();
	}

	@Override
	public String toString() {
		return "Inscripcion [id=" + id + ", activo=" + activo + ", estudiante=" + estudiante + ", carrera=" + carrera
				+ ", escolaridad=" + escolaridad + "]";
	} 
	

	
	
	

	
   
}
