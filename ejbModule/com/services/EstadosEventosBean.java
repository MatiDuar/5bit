package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.EstadosEventos;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EstadosEventosBean
 */
@Stateless
public class EstadosEventosBean implements EstadosEventosBeanRemote {

    /**
     * Default constructor. 
     */
    public EstadosEventosBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
	
    @Override
   	public void crearEstadoEvento(EstadosEventos estado) throws ServicesException {
   		
   		try {
   			
   			em.merge(estado);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el estado del evento"); 
   		}
   	}
   	
   	@Override
	public void modificarEstadoEvento(EstadosEventos estado) throws ServicesException{
		
		try {
			
			em.merge(estado);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el estado del evento"); 
		}
	}
   	
   	@Override
   	public void borrarEstadoEvento(Long id) throws ServicesException {
   		
   		try {
            
            EstadosEventos estado= em.find(EstadosEventos.class, id);
   			
   			em.remove(estado);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo BORRAR el estado del evento"); 
   		}
   	}
   	
   	@Override
	public EstadosEventos buscarEstadoEventoPorId(Long id) throws ServicesException {
		
		try {
			
			EstadosEventos estado= em.find(EstadosEventos.class, id);
			
			return estado;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el estado del evento"); 
		}
	}
	
	 @Override
	public List<EstadosEventos> obtenerEstadosEventos() throws ServicesException {
		
		try {
			
			//Capaz que esto se rompe porque al crear la clase se le puso al nombre de la tabla "ESTADOSEVENTOS".		
			TypedQuery<EstadosEventos> query = em.createQuery("SELECT DISTINCT e FROM EstadosEventos e",EstadosEventos.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de estados de eventos"); 
		}
		
	}
	
	@Override
	public EstadosEventos buscarNombreEstadoEvento (String nombreEstadoEvento) throws ServicesException {
		
		try {
			

			TypedQuery<EstadosEventos> query = em.createQuery("SELECT e FROM EstadosEventos e WHERE e.nombreEstadoEvento = :nombreEstadoEvento",EstadosEventos.class)
					.setParameter("nombreEstadoEvento", nombreEstadoEvento);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {
            
			return null;
			 
		}
	}
   	

}
