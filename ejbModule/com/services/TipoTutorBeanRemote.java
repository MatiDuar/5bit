package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoTutor;
import com.exception.ServicesException;

@Remote
public interface TipoTutorBeanRemote {
	
	void borrarTipoTutor(Long id) throws ServicesException;

	void modificarTipoTutor(TipoTutor tipoTutor) throws ServicesException;

	List<TipoTutor> obtenerTipoTutor() throws ServicesException;

	TipoTutor buscarTipoTutorPorId(Long id) throws ServicesException;

	void crearTipoTutor(String nombre) throws ServicesException;

}
