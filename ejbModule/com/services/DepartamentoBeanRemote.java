package com.services;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.exception.ServicesException;

@Remote
public interface DepartamentoBeanRemote {

	void crearDepartamento(String nombre, Boolean activo) throws ServicesException;

	void borrarDepartamento(Long id) throws ServicesException;

	Departamento buscarDepPorId(Long id) throws ServicesException;

}
