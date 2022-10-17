package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Analista
 *
 */
@Entity
public class Analista implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue
	private Long id;
	public Analista() {
		super();
	} 
	
   
}
