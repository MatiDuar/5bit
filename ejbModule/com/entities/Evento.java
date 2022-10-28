package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENTO" )
	@SequenceGenerator(name = "SEQ_EVENTO", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private Date FechaInicio;

	@Column(nullable = false)
	private Date FechaFin;

	@Column(nullable = false, length = 50)
	private String titulo;

	@ManyToOne
	private TipoActividad tipoActividad;

	@Column(nullable = false)
	private int creditos;

	@Column(nullable = false)
	private int semestre;

	@JoinTable(name = "RESP_TUTOR_EVENTO", joinColumns = @JoinColumn(name = "FK_EVENTO", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "FK_TUTOR_EVENTO", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private Set<Tutor> tutores;

	public void addTutor(Tutor tutor) {
		if (this.tutores == null) {
			this.tutores = new HashSet<>();
		}

		this.tutores.add(tutor);
	}

	@JoinTable(name = "ANALIST_GEST_EVENT", 
			joinColumns = @JoinColumn(name = "FK_EVENTO_GESTION", nullable = false), 
			inverseJoinColumns =@JoinColumn(name = "FK_ANALISTA_EVENTO", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private Set<Analista> analistas;

	public void addAnalista(Analista analista) {
		if (this.analistas == null) {
			this.analistas = new HashSet<>();
		}

		this.analistas.add(analista);
	}



	public Set<Tutor> getTutores() {
		return tutores;
	}



	public void setTutores(Set<Tutor> tutores) {
		this.tutores = tutores;
	}



	public Set<Analista> getAnalistas() {
		return analistas;
	}



	public void setAnalistas(Set<Analista> analistas) {
		this.analistas = analistas;
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
