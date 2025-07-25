package utilerias;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Utilerias {
	
	private static Utilerias instance = null;
	
	public static Utilerias getInstance() {
		if(instance == null) {
			instance = new Utilerias();
		}
		return instance;
	}
	public Utilerias () {}
	
	public void llamarVista(String path, HttpServletRequest request, HttpServletResponse response, boolean redireccion) {
		
		if(redireccion) {
			try {
				response.sendRedirect(path);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			
			try {
				
				request.getRequestDispatcher(path).forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
