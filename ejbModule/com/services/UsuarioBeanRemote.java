package com.services;

import java.sql.Date;
import java.util.List;

import com.entities.Departamento;
import com.entities.Genero;
import com.entities.ITR;
import com.entities.Usuario;
import com.exception.ServicesException;

public interface UsuarioBeanRemote {

//	void crearUsuario(String documento, String nombreUsuario, String contrasena, String apellido1, String apellido2,
//			String nombre1, String nombre2, Date fechaNacimiento, Long idGenero, Long idDepartamento, String localidad,
//			String mail, String telefono, Long idItr, boolean activo) throws ServicesException;

	void borrarUsuario(Long id) throws ServicesException;

	List<Usuario> obtenerUsuarios();

	void crearUsuario(Usuario user) throws ServicesException;

	void modificarUsuario(Long id) throws ServicesException;


	boolean estaUsuario(Usuario user);

	Usuario buscarUsuarioPorId(Long id) throws ServicesException;

}
