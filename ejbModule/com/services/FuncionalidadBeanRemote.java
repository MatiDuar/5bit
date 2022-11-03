package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Funcionalidad;
import com.exception.ServicesException;

@Remote
public interface FuncionalidadBeanRemote {

	Funcionalidad buscarNombre(String nombre) throws ServicesException;

	Funcionalidad buscarFuncionalidadPorId(Long id) throws ServicesException;

	List<Funcionalidad> obtenerFuncionalidades() throws ServicesException;

	void modificarFuncionalidad(Funcionalidad f) throws ServicesException;

	void borrarFuncionalidad(Long id) throws ServicesException;

	void crearFuncionalidad(Funcionalidad f) throws ServicesException;

}
