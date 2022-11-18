package com.entities;

import java.io.Serializable;
import javax.persistence.*;

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
	private long id;
   
}
