package com.services;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.entities.ITR;
import com.exception.ServicesException;

@Remote
public interface ITRBeanRemote {

	void crearITR(String nombre, Departamento dep, Boolean activo) throws ServicesException;

	void borrarITR(Long id) throws ServicesException;

	ITR buscarItrPorId(Long id) throws ServicesException;

}
