package modelo.dao;

import modelo.entities.Usuario;

public interface UsuarioDAO {

	public Usuario autorizar(String nombre, String clave);
	
}
