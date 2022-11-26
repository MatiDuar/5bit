package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


public class AccionConstancia implements Serializable {

	private static final long serialVersionUID = 1L;	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCION_CONSTANCIA" )
	@SequenceGenerator(name = "SEQ_ACCION_CONSTANCIA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false)
	private Date fechaHora;
	
	@Column (nullable=false, length=150)
	private String detalle;
	
	@ManyToOne
	private Constancia constancia;
	
	@ManyToOne
	private Analista analista;
	
	
	public AccionConstancia() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long idAccionConstancia) {
		this.id = idAccionConstancia;
	}


	public Date getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalleConstancia) {
		this.detalle = detalleConstancia;
	}


	public Constancia getConstancia() {
		return constancia;
	}


	public void setConstancia(Constancia constancia) {
		this.constancia = constancia;
	}


	public Analista getAnalista() {
		return analista;
	}


	public void setAnalista(Analista analista) {
		this.analista = analista;
	} 

   
}
