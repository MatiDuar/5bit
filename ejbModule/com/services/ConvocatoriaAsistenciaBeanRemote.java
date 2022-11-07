package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.exception.ServicesException;

@Remote
public interface ConvocatoriaAsistenciaBeanRemote {

	void crear(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException;

	void borrar(Long id) throws ServicesException;

	ConvocatoriaAsistencia buscarPorId(Long id) throws ServicesException;

	void modificar(ConvocatoriaAsistencia c) throws ServicesException;

	List<ConvocatoriaAsistencia> obtenerTodos() throws ServicesException;

	List<Estudiante> buscarPorEvento(Evento evento) throws ServicesException;

	ConvocatoriaAsistencia buscarPorEstudianteEvento(Estudiante estudiante, Evento evento) throws ServicesException;

	void borrar(Estudiante estudiante, Evento evento) throws ServicesException;

}
