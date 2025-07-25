package controlador;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.dao.DAOFactory;
import modelo.dao.UsuarioDAO;
import modelo.entities.Departamento;
import modelo.entities.Usuario;
import utilerias.Utilerias;

@WebServlet("/GestionarPersonaController")
public class GestionarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Usuario usuarioModelo;

	private UsuarioDAO personaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public GestionarPersonaController() {
		super();
		usuarioModelo = new Usuario();
		personaDAO = DAOFactory.getFactory().getUsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogeado") == null) {
			System.out.println("Seguridad");
			response.sendRedirect("jsp/login.jsp");
		} else {
			this.rutear(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.rutear(request, response);
	}

	private void rutear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.request = request;
		this.response = response;
		
		String ruta = (request.getParameter("ruta") == null) ? "listar" : request.getParameter("ruta");

		switch (ruta) {
		case "listar":
			this.listar();
			break;
		case "nuevo":
			this.nuevo();
			break;
		case "guardar":
			usuarioModelo
					.setId((request.getParameter("txtId") == "") ? 0 : Integer.parseInt(request.getParameter("txtId")));
			usuarioModelo.setNombre(request.getParameter("txtNombre"));
			usuarioModelo.setCorreo(request.getParameter("txtCorreo"));
			usuarioModelo.setDepartamento(DAOFactory.getFactory().getDepartamentoDAO()
					.getById(Integer.parseInt(request.getParameter("idDepartamento"))));
			usuarioModelo.setPassword(request.getParameter("txtClave"));
			this.guardar(usuarioModelo.getId(), usuarioModelo.getNombre(), usuarioModelo.getPassword(),
					usuarioModelo.getCorreo(), usuarioModelo.getDepartamento());
			break;
		case "changepass":
			usuarioModelo
					.setId((request.getParameter("txtId") == "") ? 0 : Integer.parseInt(request.getParameter("txtId")));
			usuarioModelo.setPassword(request.getParameter("txtClave"));
			this.changepass(usuarioModelo.getId(), usuarioModelo.getPassword());
			break;
		case "actualizar":
			int idPersona = Integer.parseInt(request.getParameter("idPersona"));
			this.actualizar(idPersona);
			break;
		case "eliminar":
			usuarioModelo.setId(Integer.parseInt(request.getParameter("idPersona")));
			this.eliminar(usuarioModelo.getId());
			break;
		default:
			this.listar();
			break;
		}

	}

	private void changepass(int id, String clave) {
		Usuario persona = personaDAO.getById(id);
		persona.setPassword(clave);
		personaDAO.update(persona);
		
		Utilerias.getInstance().llamarVista("GestionarPersonaController?ruta=listar", request, response, false);
	}

	private void guardar(int id, String nombre, String clave, String correo, Departamento departamento) {

		Usuario persona = new Usuario(id, nombre, clave, correo, departamento, false);

		personaDAO.create(persona);

		// 3.- Navego a la vista
		Utilerias.getInstance().llamarVista("GestionarPersonaController?ruta=listar", request, response, true);

	}

	private void eliminar(int idPersona){

		try {

			Utilerias.getInstance().llamarVista("GestionarPersonaController?ruta=listar", request, response, true);

		} catch (Exception e) {
			
			request.setAttribute("mensaje", e.getMessage());
			request.setAttribute("path", "GestionarPersonaController?ruta=listar");
			Utilerias.getInstance().llamarVista("LoginController?ruta=error", request, response, false);
		}
	}

	private void actualizar(int idPersona){

		request.setAttribute("persona", personaDAO.getById(idPersona));

		Utilerias.getInstance().llamarVista("/jsp/actualizarPersona.jsp", request, response, false);

	}

	private void nuevo() {

		request.setAttribute("departamentos", DAOFactory.getFactory().getDepartamentoDAO().getAll());
		
		Utilerias.getInstance().llamarVista("/jsp/insertarPersona.jsp", request, response, false);

	}

	private void listar(){

		request.setAttribute("personas", personaDAO.getAll());

		Utilerias.getInstance().llamarVista("/jsp/listarPersonas.jsp", request, response, false);
	}

}
