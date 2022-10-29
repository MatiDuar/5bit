package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Generacion;
import com.exception.ServicesException;

@Remote
public interface GeneracionBeanRemote {

	void crearGeneracion(Generacion gen) throws ServicesException;

	void borrarGeneracion(Long id) throws ServicesException;

	void modificarGeneracion(Generacion gen) throws ServicesException;

	List<Generacion> obtenerGeneraciones() throws ServicesException;

	Generacion buscarGeneracionPorId(Long id) throws ServicesException;

	void crearGeneracion(byte anoIngreso, Boolean activo) throws ServicesException;

}
