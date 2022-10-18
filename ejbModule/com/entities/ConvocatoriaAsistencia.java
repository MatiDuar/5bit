package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConvocatoriaAsistencia
 *
 */
public class ConvocatoriaAsistencia implements Serializable {

	

private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAsistencia;
	
	@ManyToOne
	private Estudiante estudiante;
	
	@ManyToOne
	private Evento evento;
	
	@Column (nullable=false)
	private int calificacion;
	
	@ManyToOne
	private EstadoAsistencia estadoAsistencia;
	
	public ConvocatoriaAsistencia() {
		super();
	}

	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
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

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public EstadoAsistencia getEstadoAsistencia() {
		return estadoAsistencia;
	}

	public void setEstadoAsistencia(EstadoAsistencia estadoAsistencia) {
		this.estadoAsistencia = estadoAsistencia;
	}

	@Override
	public String toString() {
		return "ConvocatoriaAsistencia [idAsistencia=" + idAsistencia + ", estudiante=" + estudiante + ", evento="
				+ evento + ", calificacion=" + calificacion + ", estadoAsistencia=" + estadoAsistencia + "]";
	}
	
   
}
