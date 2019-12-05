package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Modelo;
import modelo.Usuario;
import modelo.Coches;

/**
 * Servlet implementation class AJAXCheckNombreController
 */
@WebServlet("/AJAXCheckCochesController")
public class AJAXCheckCochesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AJAXCheckCochesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Pedir al modelo que nos consulte si existe este nombre 
		// en la tabla empleados
		Modelo m = new Modelo();
		ArrayList<Object> coches = m.getCoches();	
		
		
		if(coches.size() > 0) {
			response.setStatus(HttpServletResponse.SC_OK);
		    response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			response.getWriter().write(coches.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} else {
			response.getWriter().print("no funciono");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
