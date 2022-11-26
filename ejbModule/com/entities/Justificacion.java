package com.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

public class Justificacion implements Serializable {

	public Justificacion() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JUSTIFICACION" )
	@SequenceGenerator(name = "SEQ_JUSTIFICACION", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false)
	private Time fechaHora;
	
	@Column(nullable=false,length=150)
	private String detalle;
	@ManyToOne(optional=false)
	private Estudiante estudiante;

	@ManyToOne(optional=false)
	private Evento evento;
	
	@ManyToOne(optional=false)
	private Estado estado;

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Time fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Justificacion [id=" + id + ", fechaHora=" + fechaHora + ", estudiante=" + estudiante + ", evento="
				+ evento + ", estado=" + estado + "]";
	}
	
	
	
	
   
}
