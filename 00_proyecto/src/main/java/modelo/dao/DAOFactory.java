package modelo.dao;

import modelo.MemoriaImplementacionDAO.MemoriaDAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new MemoriaDAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract UsuarioDAO getUsuarioDAO();
}
