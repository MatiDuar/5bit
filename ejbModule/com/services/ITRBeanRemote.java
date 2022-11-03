package com.services;


import java.util.List;
import javax.ejb.Remote;

import com.entities.Departamento;
import com.entities.ITR;
import com.exception.ServicesException;

@Remote
public interface ITRBeanRemote {

	void crearITR(String nombre, Departamento dep, Boolean activo) throws ServicesException;

	void borrarITR(Long id) throws ServicesException;

	ITR buscarItrPorId(Long id) throws ServicesException;


	List<ITR> obtenerItrs() throws ServicesException;

	ITR obtenerItrPorNombre(String nombre) throws ServicesException;

	void actualizarITR(ITR itr) throws ServicesException;


}
