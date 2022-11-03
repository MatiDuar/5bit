package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Funcionalidad;
import com.exception.ServicesException;

/**
 * Session Bean implementation class FuncionalidadBean
 */
@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public FuncionalidadBean() {
    }
    
    
    @Override
   	public void crearFuncionalidad(Funcionalidad f) throws ServicesException {
   		
   		try {
   			
   			em.merge(f);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo crear el Rol"); 

   		}
   	}
   	
   	
   	
   	@Override
   	public void borrarFuncionalidad(Long id) throws ServicesException {
   		
   		try {
   			
   			Funcionalidad f= em.find(Funcionalidad.class, id);
   			
   			em.remove(f);
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo BORRAR la funcionalidad"); 
   		}
   	}
   	
   	
   	
   	@Override
   	public void modificarFuncionalidad(Funcionalidad f) throws ServicesException{
   		
   		try {
   			
   			em.merge(f);
   			
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo MODIFICAR la funcionalidad"); 
   		}
   	}
   	
   	@Override
   	public List<Funcionalidad> obtenerFuncionalidades() throws ServicesException {
   		
   		try {
   		

   			TypedQuery<Funcionalidad> query = em.createQuery("SELECT DISTINCT f FROM Funcionalidad f",Funcionalidad.class);
   		
   			return query.getResultList();
   		
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo obtener la lista de roles"); 
   		}
   		
   	}
   	
   	@Override
   	public Funcionalidad buscarFuncionalidadPorId(Long id) throws ServicesException {
   		
   		try {
   			
   			Funcionalidad f= em.find(Funcionalidad.class, id);
   			
   			return f;
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se encontro la funcionalidad"); 
   		}
   	}
   	
   	@Override
	public Funcionalidad buscarNombre (String nombre) throws ServicesException {
		
		try {
			

			TypedQuery<Funcionalidad> query = em.createQuery("SELECT f FROM Funcionalidad f WHERE f.nombre = :nombre",Funcionalidad.class)
					.setParameter("nombre", nombre);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}

}
