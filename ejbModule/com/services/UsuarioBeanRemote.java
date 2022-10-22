package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface UsuarioBeanRemote {
	
//	void crearUsuario(String documento, String nombreUsuario, String contrasena, String apellido1, String apellido2,
//	String nombre1, String nombre2, Date fechaNacimiento, Long idGenero, Long idDepartamento, String localidad,
//	String mail, String telefono, Long idItr, boolean activo) throws ServicesException;
	
	void borrarUsuario(Long id) throws ServicesException;

	List<Usuario> obtenerUsuarios() throws ServicesException;

	void crearUsuario(Usuario user) throws ServicesException;


	Usuario buscarUsuarioPorId(Long id) throws ServicesException;

	void modificarUsuario(Usuario user) throws ServicesException;

	Usuario verificarUsuario(String nombreUsuario, String contrasena) throws ServicesException;
}
