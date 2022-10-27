package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Evento;
import com.exception.ServicesException;

@Remote
public interface EventoBeanRemote {

	void crearEvento(Evento evento) throws ServicesException;

	void borrarEvento(Long id) throws ServicesException;

	Evento buscarEventoPorId(Long id) throws ServicesException;

	void modificarEvento(Evento evento) throws ServicesException;

	List<Evento> obtenerEvento() throws ServicesException;

}
