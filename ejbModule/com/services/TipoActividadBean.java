package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoActividad;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoActividadBEan
 */
@Stateless
public class TipoActividadBean implements TipoActividadBeanRemote {
	
	
	@PersistenceContext
	private EntityManager em;
    public TipoActividadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void crearTipoActividad(String nombre, Boolean activo) throws ServicesException {
   		
   		try {
   			
   			TipoActividad ta= new TipoActividad();
   			
   			ta.setNombre(nombre);
   			
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
		
			TypedQuery<TipoActividad> query = em.createQuery("SELECT DISTINCT t FROM TIPOS_ACTIVIDADES t",TipoActividad.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de Tipos de actividad"); 
		}
		
	}

}
