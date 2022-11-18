package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Escolaridad
 *
 */
public class MatriculaMateria implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public MatriculaMateria() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATRICULA" )
	@SequenceGenerator(name = "SEQ_MATRICULA", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column
	private int creditos;	

	@Column
	private int calificacion;
	
	@OneToOne
	private Estudiante estudiante;
	
	@ManyToOne
	private Materia materia;
	
}
