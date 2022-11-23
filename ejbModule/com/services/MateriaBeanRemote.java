package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Materia;
import com.exception.ServicesException;

@Remote
public interface MateriaBeanRemote {

	List<Materia> obtenerMaterias() throws ServicesException;

	void modificar(Materia materia) throws ServicesException;

	Materia buscarMateriaPorId(Long id) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	void crearMateria(Materia materia) throws ServicesException;

	Materia obtenerMateriaPorNombre(String nombre) throws ServicesException;

}
