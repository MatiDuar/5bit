package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Tutor;
import com.exception.ServicesException;

@Remote
public interface TutorBeanRemote {

	void crearTutor(Tutor tutor) throws ServicesException;

	void borrarTutor(Long id) throws ServicesException;

	Tutor buscarTutorPorId(Long id) throws ServicesException;

	void modificarTutor(Tutor tutor) throws ServicesException;

	List<Tutor> obtenerTutor() throws ServicesException;

}
