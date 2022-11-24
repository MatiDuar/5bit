package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Estudiante;
import com.entities.Inscripcion;
import com.exception.ServicesException;

@Remote
public interface InscripcionBeanRemote {

	void modificar(Inscripcion inscripcion) throws ServicesException;

	Inscripcion buscarInscripcionPorId(Long id) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	void crearInscripcion(Inscripcion inscripcion) throws ServicesException;

	List<Inscripcion> obtenerInscripciones() throws ServicesException;

	List<Inscripcion> obtenerInscripcionesPorEstudiante(Estudiante es) throws ServicesException;

}
