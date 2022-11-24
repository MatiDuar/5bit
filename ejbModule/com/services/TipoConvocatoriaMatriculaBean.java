package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ITR;
import com.entities.TipoAsignatura;
import com.entities.TipoConvocatoriaMatricula;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoConvocatoriaMatricula
 */
@Stateless
public class TipoConvocatoriaMatriculaBean implements TipoConvocatoriaMatriculaBeanRemote {

    public TipoConvocatoriaMatriculaBean() {
    }
    @PersistenceContext
	private EntityManager em;

	@Override
	public void crearTipoConvocatoriaMatricula(TipoConvocatoriaMatricula tipoConvocatoriaMatricula) throws ServicesException {

		try {

			em.merge(tipoConvocatoriaMatricula);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo CREAR el Tipo Convocatoria Matricula");
		}
	}
	
	@Override
	public void crearTipoConvocatoriaMatricula(String nombre,boolean activo) throws ServicesException {

		try {
			TipoConvocatoriaMatricula ta=new TipoConvocatoriaMatricula();
			ta.setNombre(nombre);
			ta.setActivo(activo);
			em.merge(ta);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo CREAR el Tipo Convocatoria Matricula");
		}
	}

	@Override
	public void borrar(Long id) throws ServicesException {
		try {
			TipoConvocatoriaMatricula tipoConvocatoriaMatricula = em.find(TipoConvocatoriaMatricula.class, id);

			em.remove(tipoConvocatoriaMatricula);
			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el Tipo Convocatoria Matricula");
		}
	}

	@Override
	public TipoConvocatoriaMatricula buscarTipoAsignaturaPorId(Long id) throws ServicesException {

		try {

			TipoConvocatoriaMatricula i = em.find(TipoConvocatoriaMatricula.class, id);

			return i;

		} catch (PersistenceException e) {
			throw new ServicesException("No se encontro el Tipo Convocatoria Matricula");
		}
	}

	@Override
	public void modificar(TipoConvocatoriaMatricula tipoConvocatoriaMatricula) throws ServicesException {

		try {

			em.merge(tipoConvocatoriaMatricula);

			em.flush();

		} catch (PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el Tipo Convocatoria Matricula");
		}
	}

	@Override
	public List<TipoConvocatoriaMatricula> obtenerTipoConvocatoriaMatricula() throws ServicesException {

		try {

			TypedQuery<TipoConvocatoriaMatricula> query = em.createQuery("SELECT DISTINCT t FROM TipoConvocatoriaMatricula t", TipoConvocatoriaMatricula.class);

			return query.getResultList();

		} catch (PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Tipos Convocatorias Matriculas");
		}

	}
	
	@Override
	public TipoConvocatoriaMatricula obtenerTipoConvocatoriaMatriculaPorNombre(String nombre) throws ServicesException {
		
		try {
		
			TypedQuery<TipoConvocatoriaMatricula> query = em.createQuery("SELECT t FROM TipoConvocatoriaMatricula t WHERE t.nombre=:nombre",TipoConvocatoriaMatricula.class)
					.setParameter("nombre", nombre);
		
			return query.getSingleResult();
		
		}catch(PersistenceException e) {
			return null;
		}
		
	}
}
