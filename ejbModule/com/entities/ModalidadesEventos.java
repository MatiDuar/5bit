package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ModalidadesEventos
 *
 */
 
@Entity
public class ModalidadesEventos implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public ModalidadesEventos() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADOS_MODALIDADES" )
	@SequenceGenerator(name = "SEQ_ESTADOS_MODALIDADES", initialValue = 1, allocationSize = 1)
	private Long id_modalidad;
	
	@Column(nullable=false,length=20)
	private String nombreModalidadEvento;
	
	@Column(nullable=false)
	private Boolean activo;

	public Long getId() {
		return id_modalidad;
	}

	public void setId(Long id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	public String getNombre() {
		return nombreModalidadEvento;
	}

	public void setNombre(String nombre) {
		this.nombreModalidadEvento = nombreModalidadEvento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Estado [id_modalidad=" + id_modalidad + ", nombreModalidadEvento=" + nombreModalidadEvento + ", activo=" + activo + "]";
	}
	
	
   
}
