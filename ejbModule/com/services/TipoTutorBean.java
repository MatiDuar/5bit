package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoTutor;
import com.entities.Tutor;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoTutor
 */
@Stateless
public class TipoTutorBean implements TipoTutorBeanRemote {

    public TipoTutorBean() {
    }
    
    @PersistenceContext
	private EntityManager em;
    
    @Override
   	public void crearTipoTutor(String nombre) throws ServicesException {
   		
   		try {
   			TipoTutor tipoTutor=new TipoTutor();
   			tipoTutor.setNombre(nombre);
   			em.persist(tipoTutor);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el Tipo de tutor"); 
   		}
   	}
    
    @Override
	public void borrarTipoTutor(Long id) throws ServicesException {
		try {
			TipoTutor tipoTutor= em.find(TipoTutor.class, id);
			
			em.remove(tipoTutor);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el Tipo de tutor"); 
		}
	}
    
    @Override
	public TipoTutor buscarTipoTutorPorId(Long id) throws ServicesException {
		
		try {
			
			TipoTutor ttp= em.find(TipoTutor.class, id);
			
			return ttp;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el Tipo de tutor"); 
		}
	}
    
    @Override
	public void modificarTipoTutor(TipoTutor tipoTutor) throws ServicesException{
		
		try {
			
			em.merge(tipoTutor);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el Tipo de tutor"); 
		}
	}
    
    @Override
	public List<TipoTutor> obtenerTipoTutor() throws ServicesException {
		
		try {
		
			TypedQuery<TipoTutor> query = em.createQuery("SELECT DISTINCT t FROM TipoTutor t",TipoTutor.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de Tipos de tutor"); 
		}
		
	}

}
