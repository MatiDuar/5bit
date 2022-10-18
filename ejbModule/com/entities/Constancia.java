package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Constancia
 *
 */
public class Constancia implements Serializable {

	
private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idConstancia;
	
	@Column(nullable=false)
	private Date fechaHora;
	
	@Column (nullable=false, length=150)
	private String detalle;
	
	@ManyToOne
	private Evento evento;
	
	@ManyToOne
	private Estado estado;
	
	@ManyToOne
	private TipoConstancia tipoConstancia;
	
	public Constancia() {
		super();
	}

	public Long getIdConstancia() {
		return idConstancia;
	}

	public void setIdConstancia(Long idConstancia) {
		this.idConstancia = idConstancia;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoConstancia getTipoConstancia() {
		return tipoConstancia;
	}

	public void setTipoConstancia(TipoConstancia tipoConstancia) {
		this.tipoConstancia = tipoConstancia;
	}

	@Override
	public String toString() {
		return "Constancia [idConstancia=" + idConstancia + ", fechaHora=" + fechaHora + ", detalle=" + detalle
				+ ", evento=" + evento + ", estado=" + estado + ", tipoConstancia=" + tipoConstancia + "]";
	}
	
   
}
