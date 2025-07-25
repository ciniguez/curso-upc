package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.DAOFactory;
import modelo.entities.Usuario;


@WebServlet("/servlet")
public class MiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = "Carlos";
		String clave = "carlos123";
		
		Usuario u = DAOFactory.getFactory().getUsuarioDAO().autorizar(nombre, clave);
		
		if(u == null) {
			System.out.println("NO le dejamos pasar.");
		}else {
			System.out.println("PASE POR FAVOR!");
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entró por POST");
		super.doPost(req, resp);
	}

}
