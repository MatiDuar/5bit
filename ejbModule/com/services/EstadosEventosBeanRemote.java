package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstadosEventos;
import com.exception.ServicesException;

@Remote
public interface EstadosEventosBeanRemote {
	
	void crearEstadoEvento(EstadosEventos estado) throws ServicesException;

	void borrarEstadoEvento(Long id) throws ServicesException;

	EstadosEventos buscarEstadoEventoPorId(Long id) throws ServicesException;

	List<EstadosEventos> obtenerEstadosEventos() throws ServicesException;

	EstadosEventos buscarNombreEstadoEvento(String nombreEstadoEvento) throws ServicesException;
	
	void modificarEstadoEvento(EstadosEventos estado) throws ServicesException;
}
