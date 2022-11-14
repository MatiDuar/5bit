package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoActividad;
import com.exception.ServicesException;

@Remote
public interface TipoActividadBeanRemote {

	void crearTipoActividad(String nombre, Boolean activo) throws ServicesException;

	void borrarTipoActividad(Long id) throws ServicesException;

	void modificarTipoActividad(TipoActividad ta) throws ServicesException;

	List<TipoActividad> obtenerTipoActividad() throws ServicesException;

	TipoActividad buscarTipoActividadPorId(Long id) throws ServicesException;

	TipoActividad obtenerTipoActividadPorNombre(String nombre) throws ServicesException;

}
