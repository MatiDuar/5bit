package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Analista
 *
 */
@Entity
public class Analista implements Serializable {

	

	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAnalista;
	@ManyToOne(optional=false)
	private Usuario usuario;
	public Analista() {
		super();
	}
	public Long getIdAnalista() {
		return idAnalista;
	}
	public void setIdAnalista(Long idAnalista) {
		this.idAnalista = idAnalista;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Analista [idAnalista=" + idAnalista + ", usuario=" + usuario + "]";
	} 
	
   
}
