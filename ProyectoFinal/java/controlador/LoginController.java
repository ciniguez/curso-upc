package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.dao.DAOFactory;
import modelo.entities.Usuario;
import utilerias.Utilerias;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse response;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.rutear(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.rutear(req, resp);
	}

	private void rutear(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");
		this.request = request;
		this.response = response;

		switch (ruta) {
		case "inicio":
			this.inicio(request, response);
			break;
			
		case "ingresar":
			// 1.- Obtengo los parámetros
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			this.ingresar(usuario, password);
			break;
			
		case "salir":
			this.salir(request, response);
			break;
			
			
		default:
			this.inicio(request, response);
			break;
		}
	}

	private void error(String mensaje, String path) {

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("path", path);

		Utilerias.getInstance().llamarVista("jsp/error.jsp", request, response, false);

	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Utilerias.getInstance().llamarVista("jsp/login.jsp", request, response, true);
	}

	private void ingresar(String usuario, String password) {

		// 2.- Verificar idenficiaciones correspondan con una persona del modelo
		Usuario personaAutorizada = DAOFactory.getFactory().getUsuarioDAO().autorizar(usuario, password);

		if (personaAutorizada != null) {
			// Creación de la sesion
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioLogeado", personaAutorizada);

			// Navego hacia el JSP pero siempre llamando al controlador
			Utilerias.getInstance().llamarVista("GestionarPersonaController?ruta=listar", request, response, true);

		} else {
			this.error("Usuario o Password Incorrecto", "LoginController");
		}
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().invalidate();
		Utilerias.getInstance().llamarVista("jsp/login.jsp", request, response, true);
	}
}
