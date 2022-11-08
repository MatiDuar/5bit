package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstadoAsistencia;
import com.exception.ServicesException;

@Remote
public interface EstadoAsistenciaBeanRemote {

	void crear(EstadoAsistencia ea) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	EstadoAsistencia buscarPorId(Long id) throws ServicesException;

	void modificar(EstadoAsistencia c) throws ServicesException;

	List<EstadoAsistencia> obtenerTodos() throws ServicesException;

	EstadoAsistencia obtenerPorNombre(String nombre) throws ServicesException;

}
