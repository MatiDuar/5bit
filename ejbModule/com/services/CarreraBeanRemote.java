package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Carrera;
import com.exception.ServicesException;

@Remote
public interface CarreraBeanRemote {

	List<Carrera> obtenerCarreras() throws ServicesException;

	void modificar(Carrera carrera) throws ServicesException;

	Carrera buscarCarreraPorId(Long id) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	void crearCarrera(Carrera carrera) throws ServicesException;

	Carrera obtenerCarreraPorNombre(String nombre) throws ServicesException;

}
