package com.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;


@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Estudiante extends Usuario implements Serializable {
	
	public Estudiante() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	


	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTUDIANTE" )
	@SequenceGenerator(name = "SEQ_ESTUDIANTE", initialValue = 1, allocationSize = 1)
	private Long idEstudiate;
	
	@Column
	private int anoIngreso;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Inscripcion> inscripciones;
	public void addInscripcion(Inscripcion inscripcion) {
		if (this.inscripciones == null) {
			this.inscripciones = new HashSet<>();
		}

		this.inscripciones.add(inscripcion);
	}
	public Long getIdEstudiate() {
		return idEstudiate;
	}

	public void setIdEstudiate(Long idEstudiate) {
		this.idEstudiate = idEstudiate;
	}

	public int getAnoIngreso() {
		return anoIngreso;
	}

	public void setAnoIngreso(int anoIngreso) {
		this.anoIngreso = anoIngreso;
	}
	public Set<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(Set<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	



	
	
	
   
}
