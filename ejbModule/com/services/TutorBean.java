package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoActividad;
import com.entities.Tutor;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
public class TutorBean implements TutorBeanRemote {

    public TutorBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    @Override
   	public void crearTutor(Tutor tutor) throws ServicesException {
   		
   		try {
   			
   			em.persist(tutor);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el tutor"); 
   		}
   	}
    
    @Override
	public void borrarTutor(Long id) throws ServicesException {
		try {
			Tutor tutor= em.find(Tutor.class, id);
			
			em.remove(tutor);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el tutor"); 
		}
	}
    
    @Override
	public Tutor buscarTutorPorId(Long id) throws ServicesException {
		
		try {
			
			Tutor tp= em.find(Tutor.class, id);
			
			return tp;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el tutor"); 
		}
	}
    
    @Override
	public void modificarTutor(Tutor tutor) throws ServicesException{
		
		try {
			
			em.merge(tutor);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el tutor"); 
		}
	}
    
    @Override
	public List<Tutor> obtenerTutor() throws ServicesException {
		
		try {
		
			TypedQuery<Tutor> query = em.createQuery("SELECT DISTINCT t FROM Tutor t",Tutor.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de tutor"); 
		}
		
	}

}
