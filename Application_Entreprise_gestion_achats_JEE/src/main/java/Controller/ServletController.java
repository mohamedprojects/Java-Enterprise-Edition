package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if (request.getParameter("login") != null && request.getParameter("password") != null) {

			String Login = request.getParameter("login");
			String Password = request.getParameter("password");
			ConnectBD.init();		
			User u = null;
			try {
				u = ConnectBD.FindUser(Login, Password);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ConnectBD cnx = new ConnectBD();
			if (u != null) {
			ArrayList<Produit> liste;
			try {
			liste = cnx.getProducts();
			request.setAttribute("User", u);
			request.setAttribute("ListeProduit", liste);
			request.getRequestDispatcher("/produit.jsp").forward(request, response);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

			} else {

			request.setAttribute("Erreur", "Login ou mot de passe incorrect");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		} 
		}
	}


