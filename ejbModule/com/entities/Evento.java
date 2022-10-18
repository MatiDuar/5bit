package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity
public class Evento implements Serializable {

	public Evento() {
		super();
	}
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private Date FechaInicio;
	
	@Column(nullable=false)
	private Date FechaFin;
	
	@Column(nullable=false,length=50)
	private String titulo;
	
	@ManyToOne
	private TipoActividad tipoActividad;
	
	@Column(nullable=false)
	private int creditos;
	
	@Column(nullable=false)
	private int semestre;

	
	@ManyToMany
	private List<Tutor> tutoresResponsable;
	
	@ManyToMany
	private List<Analista> analistasGestiona;
	
	public List<Tutor> getTutores() {
		return tutoresResponsable;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutoresResponsable = tutores;
	}

	public List<Analista> getAnalista() {
		return analistasGestiona;
	}

	public void setAnalista(List<Analista> analista) {
		this.analistasGestiona = analista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin + ", titulo=" + titulo
				+ ", tipoActividad=" + tipoActividad + ", creditos=" + creditos + ", semestre=" + semestre + "]";
	}
	
	
	
   
}
