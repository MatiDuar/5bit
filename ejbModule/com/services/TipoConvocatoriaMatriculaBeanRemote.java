package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoConvocatoriaMatricula;
import com.exception.ServicesException;

@Remote
public interface TipoConvocatoriaMatriculaBeanRemote {

	void crearTipoConvocatoriaMatricula(TipoConvocatoriaMatricula tipoConvocatoriaMatricula) throws ServicesException;

	void crearTipoConvocatoriaMatricula(String nombre, boolean activo) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	TipoConvocatoriaMatricula buscarTipoAsignaturaPorId(Long id) throws ServicesException;

	void modificar(TipoConvocatoriaMatricula tipoConvocatoriaMatricula) throws ServicesException;

	List<TipoConvocatoriaMatricula> obtenerTipoConvocatoriaMatricula() throws ServicesException;

	TipoConvocatoriaMatricula obtenerTipoConvocatoriaMatriculaPorNombre(String nombre) throws ServicesException;

}
