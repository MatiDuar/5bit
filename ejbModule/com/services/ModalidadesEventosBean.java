package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ModalidadesEventos;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ModalidadesEventosBean
 */
@Stateless
public class ModalidadesEventosBean implements ModalidadesEventosBeanRemote {

    /**
     * Default constructor. 
     */
    public ModalidadesEventosBean() {
        // TODO Auto-generated constructor stub
    }
    
     @PersistenceContext
	private EntityManager em;
	
    @Override
   	public void crearModalidadEvento (ModalidadesEventos modalidad) throws ServicesException {
   		
   		try {
   			
   			em.persist(modalidad);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR la modalidad de evento"); 
   		}
   	}
   	
   	@Override
	public void modificarModalidadEvento(ModalidadesEventos modalidad) throws ServicesException{
		
		try {
			
			em.merge(modalidad);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la modalidad de evento"); 
		}
	}
   	
   	@Override
   	public void borrarModalidadEvento(Long id) throws ServicesException {
   		
   		try {
            
            ModalidadesEventos mod= em.find(ModalidadesEventos.class, id);
   			
   			em.remove(mod);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo BORRAR la modalidad de evento"); 
   		}
   	}
   	
   	@Override
	public ModalidadesEventos buscarModalidadEventoPorId(Long id) throws ServicesException {
		
		try {
			
			ModalidadesEventos mod= em.find(ModalidadesEventos.class, id);
			
			return mod;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro la modalidad de evento"); 
		}
	}
	
	 @Override
	public List<ModalidadesEventos> obtenerModalidadesEventos() throws ServicesException {
		
		try {
			
					
			TypedQuery<ModalidadesEventos> query = em.createQuery("SELECT DISTINCT m FROM ModalidadesEventos m",ModalidadesEventos.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de modalidades de evento"); 
		}
		
	}
	
	@Override
	public ModalidadesEventos buscarNombreModalidadEvento (String nombreModalidadEvento) throws ServicesException {
		
		try {
			

			TypedQuery<ModalidadesEventos> query = em.createQuery("SELECT m FROM ModalidadesEventos m WHERE m.nombreModalidadEvento = :nombreModalidadEvento",ModalidadesEventos.class)
					.setParameter("nombreModalidadEvento", nombreModalidadEvento);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {
            
			return null;
			 
		}
	}

}
