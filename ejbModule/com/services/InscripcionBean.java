package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Escolaridad;
import com.entities.Inscripcion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class InscripcionBean
 */
@Stateless
public class InscripcionBean implements InscripcionBeanRemote {


    public InscripcionBean() {
    }
    @PersistenceContext
	private EntityManager em;

	@Override
	public void crearInscripcion(Inscripcion inscripcion) throws ServicesException {

		try {

			em.merge(inscripcion);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo CREAR la Inscripcion");
		}
	}

	@Override
	public void borrar(Long id) throws ServicesException {
		try {
			Inscripcion inscripcion = em.find(Inscripcion.class, id);

			em.remove(inscripcion);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la Inscripcion");
		}
	}

	@Override
	public Inscripcion buscarInscripcionPorId(Long id) throws ServicesException {

		try {

			Inscripcion i = em.find(Inscripcion.class, id);

			return i;

		} catch (PersistenceException e) {
			throw new ServicesException("No se encontro la Inscripcion");
		}
	}

	@Override
	public void modificar(Inscripcion inscripcion) throws ServicesException {

		try {

			em.merge(inscripcion);

			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la Inscripcion");
		}
	}

	@Override
	public List<Inscripcion> obtenerInscripciones() throws ServicesException {

		try {

			TypedQuery<Inscripcion> query = em.createQuery("SELECT DISTINCT i FROM Inscripcion i", Inscripcion.class);

			return query.getResultList();

		} catch (PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Inscripciones");
		}

	}

}
