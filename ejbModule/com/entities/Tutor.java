package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tutor
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Tutor extends Usuario implements Serializable {

	public Tutor() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	@ManyToOne(optional=false)
	private AreaTutor areaTutor;
	
	@ManyToOne(optional=false)
	private TipoTutor tipoTutor;


	public AreaTutor getAreaTutor() {
		return areaTutor;
	}

	public void setAreaTutor(AreaTutor areaTutor) {
		this.areaTutor = areaTutor;
	}

	public TipoTutor getTipoTutor() {
		return tipoTutor;
	}

	public void setTipoTutor(TipoTutor tipoTutor) {
		this.tipoTutor = tipoTutor;
	}

	
	
	
   
}
