package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ModalidadesEventos;
import com.exception.ServicesException;

@Remote
public interface ModalidadesEventosBeanRemote {
	
	void crearModalidadEvento (ModalidadesEventos modalidad) throws ServicesException;
	
	void modificarModalidadEvento(ModalidadesEventos modalidad) throws ServicesException;
	
	void borrarModalidadEvento(Long id) throws ServicesException;
	
	ModalidadesEventos buscarModalidadEventoPorId(Long id) throws ServicesException;
	
	List<ModalidadesEventos> obtenerModalidadesEventos() throws ServicesException;
	
	ModalidadesEventos buscarNombreModalidadEvento (String nombreModalidadEvento) throws ServicesException;

}
