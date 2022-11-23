package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Carrera;
import com.entities.ITR;
import com.entities.Inscripcion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class CarreraBean
 */
@Stateless
public class CarreraBean implements CarreraBeanRemote {

    public CarreraBean() {
    }
    @PersistenceContext
	private EntityManager em;

	@Override
	public void crearCarrera(Carrera carrera) throws ServicesException {

		try {

			em.merge(carrera);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException(e.getMessage());
		}
	}

	@Override
	public void borrar(Long id) throws ServicesException {
		try {
			Carrera carrera = em.find(Carrera.class, id);

			em.remove(carrera);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la Carrera");
		}
	}

	@Override
	public Carrera buscarCarreraPorId(Long id) throws ServicesException {

		try {

			Carrera c = em.find(Carrera.class, id);

			return c;

		} catch (PersistenceException e) {
			throw new ServicesException("No se encontro la Carrera");
		}
	}

	@Override
	public void modificar(Carrera carrera) throws ServicesException {

		try {

			em.merge(carrera);

			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la Carrera");
		}
	}

	@Override
	public List<Carrera> obtenerCarreras() throws ServicesException {

		try {

			TypedQuery<Carrera> query = em.createQuery("SELECT DISTINCT c FROM Carrera c", Carrera.class);

			return query.getResultList();

		} catch (PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Carreras");
		}

	}
	
	@Override
	public Carrera obtenerCarreraPorNombre(String nombre) throws ServicesException {
		
		try {
		
			TypedQuery<Carrera> query = em.createQuery("SELECT c FROM Carrera c WHERE c.nombre=:nombre",Carrera.class)
					.setParameter("nombre", nombre);
		
			return query.getSingleResult();
		
		}catch(PersistenceException e) {
			return null;
		}
		
	}

}
