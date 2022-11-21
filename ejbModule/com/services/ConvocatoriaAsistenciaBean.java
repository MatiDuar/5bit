package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ConvocatoriaAsistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.exception.ServicesException;

@Stateless
public class ConvocatoriaAsistenciaBean implements ConvocatoriaAsistenciaBeanRemote {

    public ConvocatoriaAsistenciaBean() {
        
    }
    
    @PersistenceContext
	private EntityManager em;
    
    @Override
   	public void crear(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException {
   		
   		try {
   			
   			em.persist(convocatoriaAsistencia);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR la Convocatoria Asistencia"); 
   		}
   	}
    
    @Override
	public void borrar(Long id) throws ServicesException {
		try {
			ConvocatoriaAsistencia c= em.find(ConvocatoriaAsistencia.class, id);
			
			em.remove(c);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR la Convocatoria Asistencia"); 
		}
	}
    
    @Override
	public ConvocatoriaAsistencia buscarPorId(Long id) throws ServicesException {
		
		try {
			
			ConvocatoriaAsistencia c= em.find(ConvocatoriaAsistencia.class, id);
			
			return c;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro la Convocatoria Asistencia"); 
		}
	}
    
    @Override
	public void modificar(ConvocatoriaAsistencia c) throws ServicesException{
		
		try {
			
			em.merge(c);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR la Convocatoria Asistencia"); 
		}
	}
    
    @Override
	public List<ConvocatoriaAsistencia> obtenerTodos() throws ServicesException {
		
		try {
		
			TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT DISTINCT c FROM ConvocatoriaAsistencia c",ConvocatoriaAsistencia.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {

			throw new ServicesException("No se pudo obtener la lista de Convocatoria Asistencia"); 
		}
		
	}
    
    @Override
   	public List<Estudiante> buscarPorEvento(Evento evento) throws ServicesException {
   		
   		try {
   		
   			TypedQuery<Estudiante> query = em.createQuery("SELECT c.estudiante FROM ConvocatoriaAsistencia c WHERE c.evento =:evento",Estudiante.class)
   					.setParameter("evento", evento);
   		
   			return query.getResultList();
   		
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo obtener la de estudiantes asignados a la Convocatoria Asistencia"); 
   		}
   		
   	}
    
    
    @Override
   	public List<ConvocatoriaAsistencia> buscarConvocatoriasPorEvento(Evento evento) throws ServicesException {
   		
   		try {
   		
   			TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT c FROM ConvocatoriaAsistencia c WHERE c.evento =:evento",ConvocatoriaAsistencia.class)
   					.setParameter("evento", evento);
   		
   			return query.getResultList();
   		
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo obtener la de estudiantes asignados a la Convocatoria Asistencia"); 
   		}
   		
   	}
    
    @Override
	public ConvocatoriaAsistencia buscarPorEstudianteEvento (Estudiante estudiante,Evento evento) throws ServicesException {	
		try {
			TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT e FROM ConvocatoriaAsistencia e WHERE e.estudiante = :estudiante AND e.evento=:evento",ConvocatoriaAsistencia.class)
					.setParameter("estudiante", estudiante)
					.setParameter("evento", evento);
			return query.getSingleResult();	
		}catch(PersistenceException e) {

			return null;
			 
		}
	}
    
    @Override
	public void borrar (Estudiante estudiante,Evento evento) throws ServicesException {
		
		try {

			em.remove(buscarPorEstudianteEvento(estudiante, evento));
			em.flush();
		
			
		}catch(PersistenceException e) {

   			throw new ServicesException("No se pudo borrar la Convocatoria Asistencia"); 
			 
		}
	}

}
