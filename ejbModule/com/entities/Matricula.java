package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
public class Matricula implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Matricula() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATRICULA" )
	@SequenceGenerator(name = "SEQ_MATRICULA", initialValue = 1, allocationSize = 1)
	private Long id;
	

	@Column(nullable=false)
	private Boolean activo;
	
	@Column(nullable=true)
	private float nota;	
	
	@Column(nullable=false)
	private int creditos;	
	
	@Column(nullable=false)
	private int semestre;	


	
	@Column(nullable=false)
	private Date fecha_inscripcion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Materia materia;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Inscripcion inscripcion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoAsignatura tipoAsignatura;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoConvocatoriaMatricula convocatoriaTipo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	

	
	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	

	public TipoAsignatura getTipoAsignatura() {
		return tipoAsignatura;
	}

	public void setTipoAsignatura(TipoAsignatura tipoAsignatura) {
		this.tipoAsignatura = tipoAsignatura;
	}

	public TipoConvocatoriaMatricula getConvocatoriaTipo() {
		return convocatoriaTipo;
	}

	public void setConvocatoriaTipo(TipoConvocatoriaMatricula convocatoriaTipo) {
		this.convocatoriaTipo = convocatoriaTipo;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", activo=" + activo + ", nota=" + nota + ", creditos=" + creditos
				+ ", semestre=" + semestre + ", fecha_inscripcion=" + fecha_inscripcion + ", materia=" + materia
				+ ", inscripcion=" + inscripcion + ", tipoAsignatura=" + tipoAsignatura + ", convocatoriaTipo="
				+ convocatoriaTipo + "]";
	}



	
	
	
	
	
	
   
}
