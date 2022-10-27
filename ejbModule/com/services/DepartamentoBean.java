package com.services;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.Departamento;

import com.exception.ServicesException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless

public class DepartamentoBean implements DepartamentoBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public DepartamentoBean() {
    }

    @Override
   	public void crearDepartamento(String nombre, Boolean activo) throws ServicesException {
   		
   		try {
   			
   			Departamento dep= new Departamento();
   			
   			dep.setNombre(nombre);
   			dep.setActivo(activo);
   			
   			em.persist(dep);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el usuario"); 
   		}
   	}
    
    @Override
	public void borrarDepartamento(Long id) throws ServicesException {
		
		try {
			
			Departamento dep= em.find(Departamento.class, id);
			
			em.remove(dep);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el usuario"); 
		}
	}
    
    @Override
	public Departamento buscarDepPorId(Long id) throws ServicesException {
		
		try {
			
			Departamento dep= em.find(Departamento.class, id);
			
			return dep;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el usuario"); 
		}
	}

}
