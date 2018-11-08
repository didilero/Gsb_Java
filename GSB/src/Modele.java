import java.sql.*;

public class Modele {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	
	public static boolean connexion(){
		boolean rep = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais","root","");
			rep = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	rep;
	}
	
	public static boolean deconnexion(){
		boolean rep = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion.close();
			rep = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
}
