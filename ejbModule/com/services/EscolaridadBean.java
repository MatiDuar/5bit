package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Escolaridad;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EscolaridadBean
 */
@Stateless
public class EscolaridadBean implements EscolaridadBeanRemote {

	public EscolaridadBean() {

	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public void crearEscolaridad(Escolaridad escolaridad) throws ServicesException {

		try {

			em.merge(escolaridad);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo CREAR la escolaridad");
		}
	}

	@Override
	public void borrar(Long id) throws ServicesException {
		try {
			Escolaridad escolaridad = em.find(Escolaridad.class, id);

			em.remove(escolaridad);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la Escolaridad");
		}
	}

	@Override
	public Escolaridad buscarEscolaridadPorId(Long id) throws ServicesException {

		try {

			Escolaridad e = em.find(Escolaridad.class, id);

			return e;

		} catch (PersistenceException e) {
			throw new ServicesException("No se encontro la Escolaridad");
		}
	}

	@Override
	public void modificar(Escolaridad escolaridad) throws ServicesException {

		try {

			em.merge(escolaridad);

			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la Escolaridad");
		}
	}

	@Override
	public List<Escolaridad> obtenerEscolaridades() throws ServicesException {

		try {

			TypedQuery<Escolaridad> query = em.createQuery("SELECT DISTINCT e FROM Escolaridad e", Escolaridad.class);

			return query.getResultList();

		} catch (PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Escolaridades");
		}

	}


}
