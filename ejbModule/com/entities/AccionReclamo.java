package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccionReclamo
 *
 */
public class AccionReclamo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAccionReclamo;
	
	@Column(nullable=false)
	private Date fechaHoraReclamo;
	
	@Column(nullable=false, length=150)
	private String detalleReclamo;
	
	@ManyToOne
	private Reclamo reclamo;
	@ManyToOne
	private Analista analista;
	public AccionReclamo() {
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
	public String getDetalleReclamo() {
		return detalleReclamo;
	}
	public void setDetalleReclamo(String detalleReclamo) {
		this.detalleReclamo = detalleReclamo;
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
		return "AccionReclamo [idAccionReclamo=" + idAccionReclamo + ", fechaHoraReclamo=" + fechaHoraReclamo
				+ ", detalleReclamo=" + detalleReclamo + ", reclamo=" + reclamo + ", analista=" + analista + "]";
	}
	
   
}
