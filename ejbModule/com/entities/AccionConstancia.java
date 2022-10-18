package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccionConstancia
 *
 */
public class AccionConstancia implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ida;
	
	@Column(nullable=false)
	private Date fechaHora;
	
	@Column (nullable=false, length=150)
	private String detalle;
	
	//Duda si es muchas acciones a muchas contancias
	@ManyToOne
	private Constancia constancia;
	
	@ManyToOne
	private Analista analista;
	
	
	public AccionConstancia() {
		super();
	}


	public Long getIdAccionConstancia() {
		return idAccionConstancia;
	}


	public void setIdAccionConstancia(Long idAccionConstancia) {
		this.idAccionConstancia = idAccionConstancia;
	}


	public Date getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	public String getDetalleConstancia() {
		return detalleConstancia;
	}


	public void setDetalleConstancia(String detalleConstancia) {
		this.detalleConstancia = detalleConstancia;
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


	@Override
	public String toString() {
		return "AccionConstancia [idAccionConstancia=" + idAccionConstancia + ", fechaHora=" + fechaHora
				+ ", detalleConstancia=" + detalleConstancia + ", constancia=" + constancia + ", analista=" + analista
				+ "]";
	} 
   
}
