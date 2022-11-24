package com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Escolaridad
 *
 */
public class Escolaridad implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Escolaridad() {
		super();
	} 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESCOLARIDAD" )
	@SequenceGenerator(name = "SEQ_ESCOLARIDAD", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER)
	Set<Matricula>matriculas;
	
	public void addMatricula(Matricula matricula) {
		if (this.matriculas == null) {
			this.matriculas = new HashSet<>();
		}

		this.matriculas.add(matricula);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Escolaridad [id=" + id + ", matriculas=" + matriculas + "]";
	}	
	
	
   
}
