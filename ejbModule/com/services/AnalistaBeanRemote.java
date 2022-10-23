package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Analista;
import com.exception.ServicesException;

@Remote
public interface AnalistaBeanRemote {

	void crearAnalista(Analista analista) throws ServicesException;

	void borrarAnalista(Long id) throws ServicesException;

	Analista buscarAnalistaPorId(Long id) throws ServicesException;

	void modificarAnalista(Analista analista) throws ServicesException;

	List<Analista> obtenerAnalista() throws ServicesException;

}
