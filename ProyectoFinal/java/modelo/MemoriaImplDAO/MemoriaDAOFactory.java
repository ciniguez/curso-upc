package modelo.MemoriaImplDAO;

import modelo.dao.DAOFactory;
import modelo.dao.DepartamentoDAO;
import modelo.dao.UsuarioDAO;

public class MemoriaDAOFactory extends DAOFactory {


	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MemoriaUsuarioDAO();
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new MemoriaDepartamentoDAO();
	}
	

}
