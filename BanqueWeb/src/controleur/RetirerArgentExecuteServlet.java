package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compteBancaire.CompteBancaire;
import ejbCompte.CompteManagerRemote;

/**
 * Servlet implementation class RetirerArgentExecuteServlet
 */
@WebServlet("/RetirerArgentExecuteServlet")
public class RetirerArgentExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteBancaire compte = new CompteBancaire();
		compte.setId(Integer.parseInt(request.getParameter("compte.id")));
		int retr = (Integer.parseInt(request.getParameter("retrait")));
		CompteManagerRemote compteManagerRemote = EjbLocator.getLocator().getCompteManager();
		CompteBancaire nouveaucompte = compteManagerRemote.mettreAJourSolde(compte, retr);
		RequestDispatcher rd = null;
		if(nouveaucompte.getId() > 0){
			rd = request.getRequestDispatcher("/WEB-INF/jsps/compteUpdated.jsp");
		}
		else{
			rd = request.getRequestDispatcher("/WEB-INF/jsps/compteError.jsp");
		}
		rd.forward(request, response);


	}

}
