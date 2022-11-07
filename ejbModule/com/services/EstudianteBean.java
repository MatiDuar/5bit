package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Estudiante;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EstudianteBean
 */
@Stateless
public class EstudianteBean implements EstudianteBeanRemote {


    public EstudianteBean() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext
	private EntityManager em;
    
    


	
	@Override
	public List<Estudiante> obtenerEstudiantes() throws ServicesException {
		
		try {
		

			TypedQuery<Estudiante> query = em.createQuery("SELECT DISTINCT e FROM Estudiante e",Estudiante.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de estudiantesa"); 
		}
		
	}

	

	@Override
	public Estudiante buscarNombre (String nombreUsuario) throws ServicesException {
		
		try {
			

			TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.nombreUsuario = :nombreUsuario",Estudiante.class)
					.setParameter("nombreUsuario", nombreUsuario);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}

}
