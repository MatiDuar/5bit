package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tutor
 *
 */
@Entity
public class Tutor implements Serializable {

	public Tutor() {
		super();
	} 
	
	private static final long serialVersionUID = 1L;	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=false)
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	private AreaTutor areaTutor;
	
	@ManyToOne(optional=false)
	private TipoTutor tipoTutor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AreaTutor getAreaTutor() {
		return areaTutor;
	}

	public void setAreaTutor(AreaTutor areaTutor) {
		this.areaTutor = areaTutor;
	}

	public TipoTutor getTipoTutor() {
		return tipoTutor;
	}

	public void setTipoTutor(TipoTutor tipoTutor) {
		this.tipoTutor = tipoTutor;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", usuario=" + usuario + ", areaTutor=" + areaTutor + ", tipoTutor=" + tipoTutor
				+ "]";
	}
	
	
	
   
}
