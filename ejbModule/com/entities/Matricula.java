package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
public class Matricula implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Matricula() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATRICULA" )
	@SequenceGenerator(name = "SEQ_MATRICULA", initialValue = 1, allocationSize = 1)
	private Long id;
	

	@Column(nullable=false)
	private Boolean activo;
	
	@Column(nullable=true)
	private float nota;	
	
	@Column(nullable=false)
	private int creditos;	


	
	@Column(nullable=false)
	private Date fecha_inscripcion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Materia materia;
	
	@ManyToOne(cascade=CascadeType.ALL)
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

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Escolaridad getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(Escolaridad escolaridad) {
		this.escolaridad = escolaridad;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", activo=" + activo + ", nota=" + nota + ", creditos=" + creditos
				+ ", fecha_inscripcion=" + fecha_inscripcion + ", materia=" + materia + ", escolaridad=" + escolaridad
				+ "]";
	}
	
	
	
	
	
	
   
}
