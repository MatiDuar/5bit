package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ITR;
import com.entities.TipoActividad;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoActividadBEan
 */
@Stateless
public class TipoActividadBean implements TipoActividadBeanRemote {
	
	

    public TipoActividadBean() {
    }
	@PersistenceContext
	private EntityManager em;
	
    @Override
   	public void crearTipoActividad(String nombre, Boolean activo, Boolean esCalificado) throws ServicesException {
   		
   		try {
   			
   			TipoActividad ta= new TipoActividad();
   			
   			ta.setNombre(nombre);
   			ta.setEsCalificado(esCalificado);
  			
   			em.persist(ta);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServicesException("No se pudo CREAR el tipo de actividad"); 
   		}
   	}
    
    @Override
	public void borrarTipoActividad(Long id) throws ServicesException {
		
		try {
			
			TipoActividad dep= em.find(TipoActividad.class, id);
			
			em.remove(dep);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el Tipo activiadad"); 
		}
	}
    
    @Override
	public TipoActividad buscarTipoActividadPorId(Long id) throws ServicesException {
		
		try {
			
			TipoActividad tp= em.find(TipoActividad.class, id);
			
			return tp;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el tipo actividad"); 
		}
	}
    
    @Override
	public void modificarTipoActividad(TipoActividad ta) throws ServicesException{
		
		try {
			
			em.merge(ta);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el tipo actividad"); 
		}
	}
    
    @Override
	public List<TipoActividad> obtenerTipoActividad() throws ServicesException {
		
		try {
		
			TypedQuery<TipoActividad> query = em.createQuery("SELECT DISTINCT t FROM TipoActividad t",TipoActividad.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de Tipos de actividad"); 
		}
		
	}
    
    @Override
	public TipoActividad obtenerTipoActividadPorNombre(String nombre) throws ServicesException {
		
		try {
		
			TypedQuery<TipoActividad> query = em.createQuery("SELECT i FROM TipoActividad i WHERE i.nombre=:nombre",TipoActividad.class)
					.setParameter("nombre", nombre);
		
			return query.getSingleResult();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener el Tipo Actividad"); 
		}
		
	}

}
