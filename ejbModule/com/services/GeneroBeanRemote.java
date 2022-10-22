package com.services;

import javax.ejb.Remote;

import com.entities.Genero;
import com.exception.ServicesException;

@Remote
public interface GeneroBeanRemote {

	void crearGenero(String nombre, Boolean activo) throws ServicesException;

	void borrarGenero(Long id) throws ServicesException;

	Genero buscarGeneroPorId(Long id) throws ServicesException;

}
