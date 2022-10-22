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
	private Long id;
	
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


	@Override
	public String toString() {
		return "AccionConstancia [id=" + id + ", fechaHora=" + fechaHora + ", detalle=" + detalle + ", constancia="
				+ constancia + ", analista=" + analista + "]";
	}


	
	
//	@Override
//	public String toString() {
//		return "AccionConstancia [idAccionConstancia=" + idAccionConstancia + ", fechaHora=" + fechaHora
//				+ ", detalleConstancia=" + detalleConstancia + ", constancia=" + constancia + ", analista=" + analista
//				+ "]";
//	} 
   
}