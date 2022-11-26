package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


public class AccionJustificacion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCION_JUSTIFICACION" )
	@SequenceGenerator(name = "SEQ_ACCION_JUSTIFICACION", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false)
	private Date fechaHora;
	
	@Column(nullable=false, length=150)
	private String detalle;
	

	@ManyToOne
	private Justificacion justificacion;
	
	@ManyToOne
	private Analista analista;
	
	public AccionJustificacion() {
		super();
	}


	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Justificacion getReclamo() {
		return justificacion;
	}

	public void setJustificacion(Justificacion justificacion) {
		this.justificacion = justificacion;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {

		return "AccionJustificacion [id=" + id + ", fechaHora=" + fechaHora + ", detalle=" + detalle + ", Justificacion="
				+ justificacion + ", analista=" + analista + "]";
	}

}
