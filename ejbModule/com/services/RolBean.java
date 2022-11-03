package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Rol;
import com.exception.ServicesException;

/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class RolBean implements RolBeanRemote {
	
	@PersistenceContext
	private EntityManager em;
	
    public RolBean() {
    }
   
    @Override
   	public void crearRol(Rol rol) throws ServicesException {
   		
   		try {
   			
   			em.merge(rol);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo crear el Rol"); 

   		}
   	}
   	
   	
   	
   	@Override
   	public void borrarRol(Long id) throws ServicesException {
   		
   		try {
   			
   			Rol rol= em.find(Rol.class, id);
   			
   			em.remove(rol);
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo BORRAR el rol"); 
   		}
   	}
   	
   	
   	
   	@Override
   	public void modificarRol(Rol rol) throws ServicesException{
   		
   		try {
   			
   			em.merge(rol);
   			
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo MODIFICAR el rol"); 
   		}
   	}
   	
   	@Override
   	public List<Rol> obtenerRoles() throws ServicesException {
   		
   		try {
   		

   			TypedQuery<Rol> query = em.createQuery("SELECT DISTINCT r FROM Rol r",Rol.class);
   		
   			return query.getResultList();
   		
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo obtener la lista de roles"); 
   		}
   		
   	}
   	
   	@Override
   	public Rol buscarUsuarioPorId(Long id) throws ServicesException {
   		
   		try {
   			
   			Rol rol= em.find(Rol.class, id);
   			
   			return rol;
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se encontro el rol"); 
   		}
   	}
   	
   	@Override
	public Rol buscarNombre (String nombre) throws ServicesException {
		
		try {
			

			TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.nombre = :nombre",Rol.class)
					.setParameter("nombre", nombre);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}

}
