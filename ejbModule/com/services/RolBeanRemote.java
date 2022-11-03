package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Rol;
import com.exception.ServicesException;

@Remote
public interface RolBeanRemote {

	Rol buscarNombre(String nombre) throws ServicesException;

	Rol buscarUsuarioPorId(Long id) throws ServicesException;

	List<Rol> obtenerRoles() throws ServicesException;

	void modificarRol(Rol rol) throws ServicesException;

	void borrarRol(Long id) throws ServicesException;

	void crearRol(Rol rol) throws ServicesException;

}
