package com.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class PlantillaConstancia implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANTILLA_CONSTANCIA" )
	@SequenceGenerator(name = "SEQ_PLANTILLA_CONSTANCIA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String nombre;
	@Column(nullable=false)
	private Boolean activo;
	
	public PlantillaConstancia() {
		super();
	} 
	
   
}
