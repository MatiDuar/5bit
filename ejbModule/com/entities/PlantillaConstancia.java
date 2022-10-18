package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PlantillaConstancia
 *
 */
@Entity
public class PlantillaConstancia implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false,length=50)
	private String nombre;
	@Column(nullable=false)
	private Boolean activo;
	
	public PlantillaConstancia() {
		super();
	} 
	
   
}
