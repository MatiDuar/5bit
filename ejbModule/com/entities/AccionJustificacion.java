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
	private Long idAccionReclamo;
	
	@Column(nullable=false)
	private Date fechaHoraReclamo;
	
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
		return idAccionReclamo;
	}

	public void setIdAccionReclamo(Long idAccionReclamo) {
		this.idAccionReclamo = idAccionReclamo;
	}

	public Date getFechaHoraReclamo() {
		return fechaHoraReclamo;
	}

	public void setFechaHoraReclamo(Date fechaHoraReclamo) {
		this.fechaHoraReclamo = fechaHoraReclamo;
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
		return "AccionJustificacion [idAccionReclamo=" + idAccionReclamo + ", fechaHoraReclamo=" + fechaHoraReclamo
				+ ", detalle=" + detalle + ", reclamo=" + reclamo + ", analista=" + analista + "]";
	} 
	
   
}
