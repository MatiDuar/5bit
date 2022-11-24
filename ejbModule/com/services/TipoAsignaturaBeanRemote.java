package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoAsignatura;
import com.exception.ServicesException;

@Remote
public interface TipoAsignaturaBeanRemote {

	void crearTipoAsignatura(TipoAsignatura tipoAsignatura) throws ServicesException;

	void crearTipoAsignatura(String nombre, boolean activo) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	TipoAsignatura buscarTipoAsignaturaPorId(Long id) throws ServicesException;

	void modificar(TipoAsignatura tipoAsignatura) throws ServicesException;

	List<TipoAsignatura> obtenerInscripciones() throws ServicesException;

	TipoAsignatura obtenerTipoAsignaturaPorNombre(String nombre) throws ServicesException;

}
