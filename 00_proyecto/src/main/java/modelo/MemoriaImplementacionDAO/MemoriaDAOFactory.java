package modelo.MemoriaImplementacionDAO;

import modelo.dao.DAOFactory;
import modelo.dao.UsuarioDAO;

public class MemoriaDAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new MemoriaUsuarioDAO();
	}

}
