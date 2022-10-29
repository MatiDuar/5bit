package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AreaTutor;
import com.exception.ServicesException;

@Remote
public interface AreaTutorBeanRemote {

	void crearAreaTutor(AreaTutor areaTutor) throws ServicesException;

	void borrarAreaTutor(Long id) throws ServicesException;

	AreaTutor buscarAreaTutorPorId(Long id) throws ServicesException;

	void modificarAreaTutor(AreaTutor areaTutor) throws ServicesException;

	List<AreaTutor> obtenerAreaTutor() throws ServicesException;

	AreaTutor buscarPorNombre(String nombre) throws ServicesException;

}
