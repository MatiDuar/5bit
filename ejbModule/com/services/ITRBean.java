package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.Departamento;
import com.entities.ITR;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ITRBean
 */
@Stateless
@LocalBean
public class ITRBean implements ITRBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public ITRBean() {
    }
    
    @Override
   	public void crearITR(String nombre, Departamento dep,Boolean activo) throws ServicesException {
   	
   		try {
   			
   			ITR itr= new ITR();
   			
   			itr.setNombre(nombre);
   			itr.setDepartamento(dep);
   			itr.setActivo(activo);
   			
   			em.persist(itr);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el usuario"); 
   		}
   	}
    
    @Override
	public void borrarITR(Long id) throws ServicesException {
		
		try {
			
			ITR itr= em.find(ITR.class, id);
			
			em.remove(itr);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el usuario"); 
		}
	}
    
    @Override
    public ITR buscarItrPorId(Long id) throws ServicesException {
		
		try {
			
			ITR itr= em.find(ITR.class, id);
			
			return itr;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el itr"); 
		}
	}

}