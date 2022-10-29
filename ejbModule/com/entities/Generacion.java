package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Generacion
 *
 */
@Entity
public class Generacion implements Serializable {
	
	public Generacion() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERACION" )
	@SequenceGenerator(name = "SEQ_GENERACION", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50,unique=true)
	private byte anoIngreso;
	
	@Column(nullable=false)
	private Boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public byte getAnoIngreso() {
		return anoIngreso;
	}

	public void setAnoIngreso(byte anoIngreso) {
		this.anoIngreso = anoIngreso;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Generacion [id=" + id + ", anoIngreso=" + anoIngreso + ", activo=" + activo + "]";
	}

	
	
   
}
