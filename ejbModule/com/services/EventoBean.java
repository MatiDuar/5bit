package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Evento;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
public class EventoBean implements EventoBeanRemote {
    public EventoBean() {
    }
    
    @PersistenceContext
	private EntityManager em;
    
    @Override
   	public void crearEvento(Evento evento) throws ServicesException {
   		
   		try {
   			
   			em.merge(evento);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el evento"); 
   		}
   	}
    
    @Override
	public void borrarEvento(Long id) throws ServicesException {
		try {
			Evento ev= em.find(Evento.class, id);
			
			em.remove(ev);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el evento"); 
		}
	}
    
    @Override
	public Evento buscarEventoPorId(Long id) throws ServicesException {
		
		try {
			
			Evento ev= em.find(Evento.class, id);
			
			return ev;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el Evento"); 
		}
	}
    
    @Override
	public void modificarEvento(Evento evento) throws ServicesException{
		
		try {
			
			em.merge(evento);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el evento"); 
		}
	}
    
    @Override
	public List<Evento> obtenerEvento() throws ServicesException {
		
		try {
		
			TypedQuery<Evento> query = em.createQuery("SELECT DISTINCT a FROM Evento a",Evento.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de eventos"); 
		}
		
	}

}
