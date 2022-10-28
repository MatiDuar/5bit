package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoConstancia
 *
 */
@Entity
public class TipoConstancia implements Serializable {

	public TipoConstancia() {
		super();
	} 
	private static final long serialVersionUID = 1L;	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_CONSTANCIA" )
	@SequenceGenerator(name = "SEQ_TIPO_CONSTANCIA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String nombre;
	
	@Column(nullable=false)
	private Boolean activo;
	
	@ManyToOne
	private PlantillaConstancia plantillaConstancia;

	public PlantillaConstancia getPlantillaConstancia() {
		return plantillaConstancia;
	}

	public void setPlantillaConstancia(PlantillaConstancia plantillaConstancia) {
		this.plantillaConstancia = plantillaConstancia;
	}

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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "TipoConstancia [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
	}
	
	
   
}
