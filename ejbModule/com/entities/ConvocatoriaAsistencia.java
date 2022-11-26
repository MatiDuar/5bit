package com.entities;

import java.io.Serializable;
import javax.persistence.*;


public class ConvocatoriaAsistencia implements Serializable {

	

private static final long serialVersionUID = 1L;	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONVOCATORIA_ASISTENCIA" )
	@SequenceGenerator(name = "SEQ_CONVOCATORIA_ASISTENCIA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@ManyToOne
	private Estudiante estudiante;
	
	@ManyToOne
	private Evento evento;
	
	@Column (nullable=false)
	private float calificacion;
	
	@ManyToOne
	private EstadoAsistencia estadoAsistencia;
	
	public ConvocatoriaAsistencia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idAsistencia) {
		this.id = idAsistencia;
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

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
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
		return "ConvocatoriaAsistencia [id=" + id + ", estudiante=" + estudiante + ", evento="
				+ evento + ", calificacion=" + calificacion + ", estadoAsistencia=" + estadoAsistencia + "]";
	}
	
   
}
