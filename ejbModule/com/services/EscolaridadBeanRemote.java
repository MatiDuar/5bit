package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Escolaridad;
import com.exception.ServicesException;

@Remote
public interface EscolaridadBeanRemote {

	List<Escolaridad> obtenerEscolaridades() throws ServicesException;

	void modificar(Escolaridad escolaridad) throws ServicesException;

	Escolaridad buscarEscolaridadPorId(Long id) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	void crearEscolaridad(Escolaridad escolaridad) throws ServicesException;

}
