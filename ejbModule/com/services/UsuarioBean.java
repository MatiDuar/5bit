package com.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.exception.ServicesException;

/**

 * Session Bean implementation class UsuarioBean
 */
@Stateless

public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public void crearUsuario(Usuario user) throws ServicesException {
		
		try {
			
			em.merge(user);
			em.flush();		
			
		}catch(PersistenceException e) {
			throw new ServicesException(e.getMessage()); 

		}
	}
	
	
	
	@Override
	public void borrarUsuario(Long id) throws ServicesException {
		
		try {
			
			Usuario user= em.find(Usuario.class, id);
			
			em.remove(user);
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo BORRAR el usuario"); 
		}
	}
	
	
	
	@Override
	public void modificarUsuario(Usuario user) throws ServicesException{
		
		try {
			
			em.merge(user);
			
			em.flush();
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo MODIFICAR el usuario"); 
		}
	}
	
	@Override
	public List<Usuario> obtenerUsuarios() throws ServicesException {
		
		try {
		

			TypedQuery<Usuario> query = em.createQuery("SELECT DISTINCT u FROM Usuario u",Usuario.class);
		
			return query.getResultList();
		
		}catch(PersistenceException e) {
			throw new ServicesException("No se pudo obtener la lista de usuarios"); 
		}
		
	}
	
	@Override
	public Usuario buscarUsuarioPorId(Long id) throws ServicesException {
		
		try {
			
			Usuario user= em.find(Usuario.class, id);
			
			return user;
			
		}catch(PersistenceException e) {
			throw new ServicesException("No se encontro el usuario"); 
		}
	}
	
	@Override
	public Usuario verificarUsuario (String nombreUsuario, String contrasena) throws ServicesException {
		
		try {
			

			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasena=:contrasena AND u.activo=1",Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario)
					.setParameter("contrasena", contrasena);

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}
	

	@Override
	public Usuario buscarNombre (String nombreUsuario) throws ServicesException {
		
		try {
			

			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario",Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}

}
