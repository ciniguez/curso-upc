package modelo.MemoriaImplementacionDAO;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.UsuarioDAO;
import modelo.entities.Usuario;

public class MemoriaUsuarioDAO implements UsuarioDAO {
	
	private static List<Usuario> usuarios = null;
	
	public MemoriaUsuarioDAO() {
		if(usuarios == null) {
			usuarios = new ArrayList<Usuario>();
			usuarios.add(new Usuario(1, "Carlos", "carlos123", true));
			usuarios.add(new Usuario(2, "Pedro", "pedro123", false));
		}
		
	}

	@Override
	public Usuario autorizar(String nombre, String clave) {
		for (Usuario usuario : usuarios) {
			if(usuario.getClave().equals(clave) && usuario.getNombre().equals(nombre)) {
				return usuario;
			}
		}
		return null;
	}

}
