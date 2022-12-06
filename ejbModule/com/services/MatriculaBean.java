package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Matricula;
import com.exception.ServicesException;

/**
 * Session Bean implementation class MatriculaBean
 */
@Stateless
public class MatriculaBean implements MatriculaBeanRemote {

 
    public MatriculaBean() {
    }
    @PersistenceContext
	private EntityManager em;

	@Override
	public void crearMatricula(Matricula matricula) throws ServicesException {

		try {

			em.merge(matricula);
			em.flush();
			

		} catch (PersistenceException e) {
			throw new ServicesException(e.getMessage());
		}
	}

	@Override
	public void borrar(Long id) throws ServicesException {
		try {
			Matricula matricula = em.find(Matricula.class, id);

			em.remove(matricula);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la Matricula");
		}
	}

	@Override
	public Matricula buscarMatriculaPorId(Long id) throws ServicesException {

		try {

			Matricula m = em.find(Matricula.class, id);

			return m;

		} catch (PersistenceException e) {
			throw new ServicesException("No se encontro la Matricula");
		}
	}

	@Override
	public void modificar(Matricula matricula) throws ServicesException {

		try {

			em.merge(matricula);

			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la Matricula");
		}
	}

	@Override
	public List<Matricula> obtenerMatriculas() throws ServicesException {

		try {

			TypedQuery<Matricula> query = em.createQuery("SELECT DISTINCT m FROM Matricula m", Matricula.class);

			return query.getResultList();

		} catch (PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Matriculas");
		}

	}

	

}
