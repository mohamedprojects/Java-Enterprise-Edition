package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idProduit = Integer.parseInt( request.getParameter("idProduit"));
		String nomProduit = request.getParameter("nomProduit");
		float prix = Float.parseFloat( request.getParameter("prixProduit"));
		int idFournisseur = Integer.parseInt( request.getParameter("idFournisseur"));
		ConnectBD cnx = new ConnectBD();
		Produit p = new  Produit(idProduit, nomProduit, idProduit, idFournisseur);
		try {
			int result = cnx.addProduct(p);
			if(result>0) {
				request.setAttribute("msg", "le produit bien ajouté");
				request.getRequestDispatcher("/produit.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
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
