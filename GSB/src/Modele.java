import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Modele {
	/***
	 * @see Classe Connection dans java.sql.*
	 * @see Classe ResultSet dans java.sql.*
	 * @see Classe PreparedStatement dans java.sql.*
	 */
	private static Connection connexion;
	private static PreparedStatement st;
	private static ResultSet rs;
	
	/***
	 * fonction connexion() qui permet d'etablir la connexion avec la base donnée
	 * @author Adrien 
	 * @return true/false
	 */
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
	/***
	 * fonction deconnexion() qui permet de rompre la connexion avec la base donnée
	 * @author Adrien 
	 * @return true/false
	 */
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
	/***
	 * Fonction trouver sur internet qui permet de hashé un mot de passe en mdp5
	 * @param key de type String
	 * @return unHash de type String
	 */
	public static String getEncodedPassword(String key) {
		  byte[] uniqueKey = key.getBytes();
		  byte[] hash = null;
		  try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		  } catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		  }
		  StringBuffer hashString = new StringBuffer();
		  for ( int i = 0; i < hash.length; ++i ) {
			String hex = Integer.toHexString(hash[i]);
			if ( hex.length() == 1 ) {
			  hashString.append('0');
			  hashString.append(hex.charAt(hex.length()-1));
			} else {
			  hashString.append(hex.substring(hex.length()-2));
			}
		  }
		  return hashString.toString();
	}
	
	/***
	 * fonction connexionUtilisateur() qui permet de verifier que les parametres 
	 * @param unLog de type String qui sont le nom de l'utilisateur
	 * @param unMdp de type String qui est le mot de passe 
	 * @author Adrien 
	 * @return 1 ou 0
	 */
	public static int connexionUtilisateur(String unLog, String unMdp){
		int rep=0;
		Modele.connexion();
		try {
			String mdp = getEncodedPassword(unMdp);
			st = connexion.prepareStatement("SELECT COUNT(login) FROM Visiteur WHERE mdp=? AND login=? AND role=1");
			st.setString(1,mdp);
			st.setString(2,unLog);
			rs = st.executeQuery();
			rs.next();
			rep = rs.getInt(1);
			rs.close();
			st.close();
			Modele.deconnexion();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	
}
