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
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Analista extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	public Analista() {
		super();
	}

	
   
}
