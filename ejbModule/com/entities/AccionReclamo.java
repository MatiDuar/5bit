package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccionReclamo
 *
 */
public class AccionReclamo implements Serializable {

	
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCION_RECLAMO" )
	@SequenceGenerator(name = "SEQ_ACCION_RECLAMO", initialValue = 1, allocationSize = 1)
	private Long id;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "AccionReclamo [id=" + id + ", fechaHoraReclamo=" + fechaHoraReclamo
				+ ", detalleReclamo=" + detalleReclamo + ", reclamo=" + reclamo + ", analista=" + analista + "]";
	}
	
   
}
