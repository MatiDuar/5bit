package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Matricula;
import com.exception.ServicesException;

@Remote
public interface MatriculaBeanRemote {

	List<Matricula> obtenerMatriculas() throws ServicesException;

	void modificar(Matricula matricula) throws ServicesException;

	Matricula buscarMatriculaPorId(Long id) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	void crearMatricula(Matricula matricula) throws ServicesException;

}
