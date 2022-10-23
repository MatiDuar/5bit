package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Analista;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AnalistaBean
 */
@Stateless
public class AnalistaBean implements AnalistaBeanRemote {
    public AnalistaBean() {
    }
    @PersistenceContext
	private EntityManager em;
    
    @Override
   	public void crearAnalista(Analista analista) throws ServicesException {
   		
   		try {
   			
   			em.persist(analista);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el analista"); 
   		}
   	}
    
    @Override
	public void borrarAnalista(Long id) throws ServicesException {
		try {
			Analista analista= em.find(Analista.class, id);
			
			em.remove(analista);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el analista"); 
		}
	}
    
    @Override
	public Analista buscarAnalistaPorId(Long id) throws ServicesException {
		
		try {
			
			Analista analista= em.find(Analista.class, id);
			
			return analista;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el analista"); 
		}
	}
    
    @Override
	public void modificarAnalista(Analista analista) throws ServicesException{
		
		try {
			
			em.merge(analista);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el analista"); 
		}
	}
    
    @Override
	public List<Analista> obtenerAnalista() throws ServicesException {
		
		try {
		
			TypedQuery<Analista> query = em.createQuery("SELECT DISTINCT a FROM ANALISTAS a",Analista.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de analista"); 
		}
		
	}
}
