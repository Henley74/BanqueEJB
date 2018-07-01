package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbCompte.CompteManagerRemote;

/**
 * Servlet implementation class listComptesServlet
 */
@WebServlet("/listComptesServlet")
public class ListComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	   public ListComptesServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CompteManagerRemote compteManagerRemote = EjbLocator.getLocator().getCompteManager();
    	request.setAttribute("listComptes", compteManagerRemote.listerComptes());
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/listComptes.jsp");
    	rd.forward(request, response);
	}

}
