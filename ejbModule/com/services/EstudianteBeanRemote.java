package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Estudiante;
import com.exception.ServicesException;

@Remote
public interface EstudianteBeanRemote {

	Estudiante buscarNombre(String nombreUsuario) throws ServicesException;

	List<Estudiante> obtenerEstudiantes() throws ServicesException;

}
