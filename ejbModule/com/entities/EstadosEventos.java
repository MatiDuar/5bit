package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EstadosEventos
 *
 */
 
@Entity
public class EstadosEventos implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public EstadosEventos() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADOS_EVENTOS" )
	@SequenceGenerator(name = "SEQ_ESTADOS_EVENTOS", initialValue = 1, allocationSize = 1)
	private Long id_estado;
	
	@Column(nullable=false,length=20)
	private String nombreEstadoEvento;
	
	@Column(nullable=false)
	private Boolean activo;

	public Long getId() {
		return id_estado;
	}

	public void setId(Long id_estado) {
		this.id_estado = id_estado;
	}

	public String getNombre() {
		return nombreEstadoEvento;
	}

	public void setNombre(String nombre) {
		this.nombreEstadoEvento = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", nombreEstadoEvento=" + nombreEstadoEvento + ", activo=" + activo + "]";
	}
	
   
}
