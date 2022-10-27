package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
/**
 * Esta entidad representa los datos de los usuarios
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	public Usuario() {
		super();
	}
	private static final long serialVersionUID = 1L;	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO" )
	@SequenceGenerator(name = "SEQ_USUARIO", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50)
	private String documento;
	
	@Column(nullable=false,length=50,unique=true)
	private String nombreUsuario;
	
	@Column(nullable=false,length=50)
	private String contrasena;
	
	@Column(nullable=false,length=50)
	private String apellido1;
	
	@Column(length=50)
	private String apellido2;
	
	@Column(nullable=false,length=50)
	private String nombre1;
	
	@Column(length=50)
	private String nombre2;
	
	@Column(nullable=false)
	private Date fechaNacimiento;
	
	@ManyToOne(optional=false)
	private Genero genero;
	
	@ManyToOne(optional=false)
	private Departamento departamento;
	
	//se asumio que la localidad se refiere a la direccion y a la ciudad
	@Column(nullable=false,length=150)
	private String localidad;
	
	@Column(nullable=false,length=50)
	private String mail;
	
	@Column(nullable=false,length=50)
	private String telefono;
	
	@ManyToOne(optional=false)
	private ITR itr;
	
	@Column(nullable=false)
	private Boolean activo;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ITR getItr() {
		return itr;
	}

	public void setItr(ITR itr) {
		this.itr = itr;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", documento=" + documento + ", nombreUsuario=" + nombreUsuario + ", contrasena="
				+ contrasena + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre1=" + nombre1
				+ ", nombre2=" + nombre2 + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero
				+ ", departamento=" + departamento + ", localidad=" + localidad + ", mail=" + mail + ", telefono="
				+ telefono + ", itr=" + itr + ", activo=" + activo + "]";
	} 
	
	
	
   
}
