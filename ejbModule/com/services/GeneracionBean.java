package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Generacion;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class GeneracionBean
 */
@Stateless
public class GeneracionBean implements GeneracionBeanRemote {


	@PersistenceContext
	private EntityManager em;
	
    public GeneracionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void crearGeneracion(Generacion gen) throws ServicesException {
		
		try {
			
			em.persist(gen);
			em.flush();		
			
		}catch(PersistenceException e) {
			throw new ServicesException(e.getMessage()); 
		}
	}
    
    @Override
   	public void crearGeneracion(byte anoIngreso,Boolean activo) throws ServicesException {
   		
   		try {
   			Generacion gen=new Generacion();
   			gen.setActivo(activo);
   			gen.setAnoIngreso(anoIngreso);
   			em.persist(gen);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException(e.getMessage()); 
   		}
   	}
	
	@Override
	public void borrarGeneracion(Long id) throws ServicesException {
		
		try {
			
			Generacion gen= em.find(Generacion.class, id);
			
			em.remove(gen);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la generacion"); 
		}
	}
	
	@Override
	public void modificarGeneracion(Generacion gen) throws ServicesException{
		
		try {
			
			em.merge(gen);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la generacion"); 
		}
	}
	
	@Override
	public List<Generacion> obtenerGeneraciones() throws ServicesException {
		
		try {
		
			TypedQuery<Generacion> query = em.createQuery("SELECT DISTINCT g FROM Generacion g",Generacion.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de generaciones"); 
		}
		
	}
	
	@Override
	public Generacion buscarGeneracionPorId(Long id) throws ServicesException {
		
		try {
			
			Generacion gen= em.find(Generacion.class, id);
			
			return gen;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro la generacion"); 
		}
	}
	
//	@Override
//	public Generacion buscarGeneracionPorAno(Long ano) throws ServicesException {
//		
//		try {
//			
//			Generacion gen= em.find(Generacion.class, ano);
//			
//			return gen;
//			
//		}catch(PersistenceException e) {
//			throw new ServicesException("No se encontro la generacion"); 
//		}
//	}
	

}
