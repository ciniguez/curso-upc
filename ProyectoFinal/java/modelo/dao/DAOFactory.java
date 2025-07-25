package modelo.dao;

//import modelo.JPAImplDAO.JPADAOFactory;
import modelo.MemoriaImplDAO.MemoriaDAOFactory;

public abstract class DAOFactory {
	
	//protected static DAOFactory factoria = new JPADAOFactory();
	protected static DAOFactory factoria = new MemoriaDAOFactory();
	
	public static DAOFactory getFactory() {
		
		return factoria;
	}
	
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract DepartamentoDAO getDepartamentoDAO();
	



}
