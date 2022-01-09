package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectBD {
	static final String URL = "jdbc:mysql://localhost:3306/gestionproduits";
	static final String Login = "root";
	static final String Password = "";
	static Connection cnx = null;
	static final int Id=1;
	public static ArrayList<String> tab; 

	public static void init() {
		try {
			cnx = (Connection) DriverManager.getConnection(URL, Login, Password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static User FindUser(String Login, String Password) throws SQLException {
		User u = null;
		try {

			Statement stm = (Statement) cnx.createStatement();
			String sql = "select * from user where login='" + Login + "'and password ='" + Password + "'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				u = new User(rs.getString(2), rs.getString(3));
				System.out.println(rs.getString(2) + rs.getString(3));
			}
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return u;

	}
	public ArrayList<Produit> getProducts() throws SQLException{
		//cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionproduits");
		cnx = (Connection) DriverManager.getConnection(URL, Login, Password);
		Statement stm = (Statement) cnx.createStatement();
		String sql = "select * from produits";
		ResultSet rs = stm.executeQuery(sql);
		ArrayList<Produit> liste = new ArrayList<Produit>();
		while(rs.next()) {
			liste.add(new Produit(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
		}
		return liste;
	}
	public int addProduct(Produit p) throws SQLException {
		cnx = (Connection) DriverManager.getConnection(URL, Login, Password);
		Statement stm = (Statement) cnx.createStatement();
		String sql = "insert into produits values("+p.getIdProduit()+", '"+p.getNomProduit()+"',"+p.getPrixProduit()+","+p.getIdFournisseur()+")";
       int result =stm.executeUpdate(sql);
       return result;
	}
	public int deleteProduct(int idProduit) throws SQLException {
		cnx = (Connection) DriverManager.getConnection(URL, Login, Password);
		Statement stm = (Statement) cnx.createStatement();
		String sql = "delete from produits where idProduit="+idProduit;
		int result = stm.executeUpdate(sql);
		return result;
	}
}
