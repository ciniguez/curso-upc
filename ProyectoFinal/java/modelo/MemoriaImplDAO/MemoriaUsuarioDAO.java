package modelo.MemoriaImplDAO;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.DAOFactory;
import modelo.dao.UsuarioDAO;
import modelo.entities.Departamento;
import modelo.entities.Usuario;

public class MemoriaUsuarioDAO implements UsuarioDAO {

	private static List<Usuario> personas = null;

	

	@Override
	public List<Usuario> getAll() {
		if (personas == null) {
			personas = new ArrayList<Usuario>();

			Departamento dep = DAOFactory.getFactory().getDepartamentoDAO().getById(1);
			System.out.println(dep);

			personas.add(new Usuario(1, "Carlos", "carlos123", "carlos@uni.com", dep, true));
			personas.add(new Usuario(2, "Pedro", "pedro123", "pedro@uni.com", dep, false));
			personas.add(new Usuario(3, "Maria", "maria123", "maria@uni.com", dep, false));
		}
		return personas;
	}

	@Override
	public Usuario autorizar(String nombre, String clave) {

		// Verifica si usuario es admin y que exista.
		Usuario personaAutorizada = null;

		for (Usuario persona : this.getAll()) {
			if (persona.getNombre().equals(nombre) && persona.getPassword().equals(clave)) {

				if (persona.isAdmin()) {
					return persona;
				} else {
					System.out.println("Usuario no es Adminsitrador");
					return null;
				}
			}
		}
		System.out.println("Usuario no existe!!");
		return null;
		
	}
	@Override
	public void create(Usuario p) {
		int max = 0;

		for(Usuario persona: this.getAll()) {
			if(max < persona.getId())
				max = persona.getId();
		}
		
		p.setId(max);
		
		if(! personas.add(p)) {
			System.out.println("Problemas en agregar un usuario.");
		}
	}

	@Override
	public void update(Usuario p) {

		for (int i = 0; i < this.getAll().size(); i++) {

			Usuario u = this.getAll().get(i);

			if (u.getId() == p.getId()) {
				u.setNombre(p.getNombre());
				u.setPassword(p.getPassword());
				u.setCorreo(p.getCorreo());
				u.setDepartamento(p.getDepartamento());
				break;
			}
		}

	}

	@Override
	public void delete(int id) {

		for (int i = 0; i < this.getAll().size(); i++) {

			if (this.getAll().get(i).getId() == id) {

				this.getAll().remove(i);

				break;
			}
		}

	}

	@Override
	public Usuario getById(int id) {

		for(Usuario persona: this.getAll()) {
			if(persona.getId()== id)
				return persona;
		}
		return null;
	}

}
