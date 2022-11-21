package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoActividad
 *
 */
@Entity
public class TipoActividad implements Serializable {

	public TipoActividad() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_ACTIVIDAD" )
	@SequenceGenerator(name = "SEQ_TIPO_ACTIVIDAD", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50,unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private Boolean esCalificado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEsCalificado() {
		return esCalificado;
	}

	public void setEsCalificado(Boolean esCalificado) {
		this.esCalificado = esCalificado;
	}

	@Override
	public String toString() {
		return "TipoActividad [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
   
}
