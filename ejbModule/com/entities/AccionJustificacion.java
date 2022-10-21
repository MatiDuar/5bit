package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccionJustificacion
 *
 */
public class AccionJustificacion implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private Date fechaHora;
	
	@Column(nullable=false, length=150)
	private String detalle;
	
	//Duda si son muchas acciones para muchos reclamos
	@ManyToOne
	private Reclamo reclamo;
	
	@ManyToOne
	private Analista analista;
	
	public AccionJustificacion() {
		super();
	}

	public Long getIdAccionReclamo() {
		return id;
	}

	public void setIdAccionReclamo(Long idAccionReclamo) {
		this.id = idAccionReclamo;
	}

	public Date getFechaHoraReclamo() {
		return fechaHora;
	}

	public void setFechaHoraReclamo(Date fechaHoraReclamo) {
		this.fechaHora = fechaHoraReclamo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Reclamo getReclamo() {
		return reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	@Override
	public String toString() {
		return "AccionJustificacion [idAccionReclamo=" + id + ", fechaHoraReclamo=" + fechaHora
				+ ", detalle=" + detalle + ", reclamo=" + reclamo + ", analista=" + analista + "]";
	} 
	
   
}
