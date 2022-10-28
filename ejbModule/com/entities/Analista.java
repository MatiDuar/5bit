package com.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Analista
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Analista extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ANALISTA" )
	@SequenceGenerator(name = "SEQ_ANALISTA", initialValue = 1, allocationSize = 1)
	private Long idAnalista;	
	
	public Analista() {
		super();
	}
	
	 @ManyToMany( mappedBy="analistas")
	 private Set <Evento> eventos;


	
   
}
