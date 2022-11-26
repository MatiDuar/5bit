package com.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Evento implements Serializable {

	public Evento() {
		super();
	}

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENTO" )
	@SequenceGenerator(name = "SEQ_EVENTO", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private Timestamp FechaInicio;

	@Column(nullable = false)
	private Timestamp FechaFin;

	@Column(nullable = false, length = 50)
	private String titulo;

	@ManyToOne
	private TipoActividad tipoActividad;
	
	@ManyToOne
	private ModalidadesEventos modalidad;

	@Column(nullable = true)
	private int creditos;

	@Column(nullable = true)
	private int semestre;
	
	@Column()
	private String localizacion;
	
	

	@ManyToOne
	private ITR itr;
	
	@ManyToOne
	private EstadosEventos estado;

	@JoinTable(name = "RESP_TUTOR_EVENTO", joinColumns = @JoinColumn(name = "FK_EVENTO", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "FK_TUTOR_EVENTO", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private List<Tutor> tutores;

	public void addTutor(Tutor tutor) {
		if (this.tutores == null) {
			this.tutores = new ArrayList<>();
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



	public List<Tutor> getTutores() {
		return tutores;
	}



	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}



	public Set<Analista> getAnalistas() {
		return analistas;
	}



	public void setAnalistas(Set<Analista> analistas) {
		this.analistas = analistas;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}



	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Timestamp  fechaFin) {
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

	
	
	public ITR getItr() {
		return itr;
	}



	public void setItr(ITR itr) {
		this.itr = itr;
	}



	public ModalidadesEventos getModalidad() {
		return modalidad;
	}



	public void setModalidad(ModalidadesEventos modalidad) {
		this.modalidad = modalidad;
	}

	public EstadosEventos getEstado() {
		return estado;
	}



	public void setEstado(EstadosEventos estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Evento [id=" + id + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin + ", titulo=" + titulo
				+ ", tipoActividad=" + tipoActividad + ", creditos=" + creditos + ", semestre=" + semestre + "]";
	}

}
