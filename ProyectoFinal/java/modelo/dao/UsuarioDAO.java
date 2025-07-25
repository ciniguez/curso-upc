package modelo.dao;

import java.util.List;

import modelo.entities.Usuario;

public interface UsuarioDAO {


	public Usuario autorizar(String nombre, String clave);

	public List<Usuario> getAll();
	
	public Usuario getById(int id);

	public void create(Usuario p);

	public void update(Usuario p);

	public void delete(int id);

	

}
