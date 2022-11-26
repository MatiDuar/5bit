package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class Carrera implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Carrera() {
		super();
	} 

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARRERA" )
	@SequenceGenerator(name = "SEQ_CARRERA", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50,unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private Boolean activo;
	
	@Column(nullable=false)
	private int cantSemestre;
	
	@Column(nullable=false)
	private int creditosObligatorios;
	
	@Column(nullable=false)
	private int creditosOptativos;
	@Column(nullable=false)
	private int creditosLibreConfiguracion;
	@Column(nullable=false)
	private int creditosProyecto;
	@Column(nullable=false)
	private int creditosPracticasProfesionales;
	
	
	@JoinTable(name = "CARRERA_MATERIA", joinColumns = @JoinColumn(name = "FK_CARRERA", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "FK_MATERIA_CARRERA", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Materia> materias;

	public void addMateria(Materia materia) {
		if (this.materias == null) {
			this.materias = new ArrayList<>();
		}

		this.materias.add(materia);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public int getCantSemestre() {
		return cantSemestre;
	}

	public void setCantSemestre(int cantSemestre) {
		this.cantSemestre = cantSemestre;
	}

	public int getCreditosObligatorios() {
		return creditosObligatorios;
	}


	public void setCreditosObligatorios(int creditosObligatorios) {
		this.creditosObligatorios = creditosObligatorios;
	}


	public int getCreditosOptativos() {
		return creditosOptativos;
	}


	public void setCreditosOptativos(int creditosOptativos) {
		this.creditosOptativos = creditosOptativos;
	}


	public int getCreditosLibreConfiguracion() {
		return creditosLibreConfiguracion;
	}


	public void setCreditosLibreConfiguracion(int creditosLibreConfiguracion) {
		this.creditosLibreConfiguracion = creditosLibreConfiguracion;
	}


	public int getCreditosProyecto() {
		return creditosProyecto;
	}


	public void setCreditosProyecto(int creditosProyecto) {
		this.creditosProyecto = creditosProyecto;
	}


	public int getCreditosPracticasProfesionales() {
		return creditosPracticasProfesionales;
	}


	public void setCreditosPracticasProfesionales(int creditosPracticasProfecionales) {
		this.creditosPracticasProfesionales = creditosPracticasProfecionales;
	}


	public List<Materia> getMaterias() {
		return materias;
	}


	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}


	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", cantSemestre=" + cantSemestre
				+ ", creditosObligatorios=" + creditosObligatorios + ", creditosOptativos=" + creditosOptativos
				+ ", creditosLibreConfiguracion=" + creditosLibreConfiguracion + ", creditosProyecto="
				+ creditosProyecto + ", creditosPracticasProfecionales=" + creditosPracticasProfesionales
				+ ", materias=" + materias + "]";
	}

	
	
	
	

	
	
   
}
