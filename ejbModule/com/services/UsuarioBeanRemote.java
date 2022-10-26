package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServicesException;

@Remote
public interface UsuarioBeanRemote {

	void crearUsuario(Usuario user) throws ServicesException;

	void borrarUsuario(Long id) throws ServicesException;

	void modificarUsuario(Usuario user) throws ServicesException;

	List<Usuario> obtenerUsuarios() throws ServicesException;

	Usuario buscarUsuarioPorId(Long id) throws ServicesException;

	Usuario verificarUsuario(String nombreUsuario, String contrasena) throws ServicesException;

}
