package modele;
import class_bdd.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class Modele {
	/***
	 * @see Classe Connection dans java.sql.*
	 * @see Classe ResultSet dans java.sql.*
	 * @see Classe PreparedStatement dans java.sql.*
	 */
	private static Connection connexion;
	private static PreparedStatement st;
	private static ResultSet rs;
	private static final String addresse = "jdbc:mysql://172.16.203.100/2018gouraud";
	private static final String util = "tgouraud";
	private static final String mdp = "123456";
	
	/***
	 * fonction connexion() qui permet d'etablir la connexion avec la base donnée
	 * @author Adrien 
	 * @return true/false
	 */
	public static boolean connexion(){
		boolean rep = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(addresse,util,mdp); // test la connexion
			rep = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
			e.printStackTrace();
		}
		catch (SQLException e) {
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
	 * fonction connexionUtilisateur() qui permet de verifier que les parametres entrer sont ceux du comptable pour se connecter a l'application.
	 * @param unLog de type String qui sont le nom de l'utilisateur
	 * @param unMdp de type String qui est le mot de passe 
	 * @author Adrien 
	 * @return true/false
	 */
	public static boolean connexionUtilisateur(String unLog, String unMdp){
		boolean rep=false;
		Modele.connexion();
		try {
			String mdpC = Modele.getEncodedPassword(unMdp);
			st = connexion.prepareStatement("SELECT COUNT(login) FROM Visiteur WHERE mdp=? AND login=? AND role=1;");
			st.setString(1,mdpC);
			st.setString(2,unLog);
			rs = st.executeQuery();
			rs.next();
			if(rs.getInt(1) == 1){
				rep = true;
			}
			rs.close();
			st.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	
	/**
	 * Fonction qui retourne une liste deslignefraisforfait enregistrer dans la bdd.
	 * @return lesfraisF de type ArrayList<LigneFraisForfait>
	 */
	public static ArrayList<FicheFrais> getFicheFrais(){
		ArrayList<FicheFrais> lesFfrais = new ArrayList<FicheFrais>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT *  FROM fichefrais WHERE idEtat='CL' ORDER BY dateModif DESC;");
			rs = st.executeQuery();
			while(rs.next()){
				lesFfrais.add(new FicheFrais(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6)));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesFfrais;
	}
	/**
	 * Fonction qui retourne le nombre de fichefrais selectioner
	 * @return
	 */
	public static int getNbFicheFrais(){
		int nb = 0;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT count(*) FROM fichefrais WHERE idEtat='CL';");
			rs = st.executeQuery();
			rs.next();
			nb=rs.getInt(1);
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return nb;
	}
	/***
	 * Fonction qui retourne toute les fiches horsforfait.
	 * @return ArrayList de type LigneFraisHorsForfait
	 */
	public static ArrayList<LigneFraisHorsForfait> getHorsForfait(){
		ArrayList<FicheFrais> lesF = Modele.getFicheFrais();
		ArrayList<LigneFraisHorsForfait> lesFH = new ArrayList<LigneFraisHorsForfait>();
		Modele.connexion();
		try {
			for(int i =0; i<lesF.size();i++){
				st = connexion.prepareStatement("SELECT * FROM lignefraishorsforfait WHERE lignefraishorsforfait.date=?;");
				st.setDate(1,lesF.get(i).getDateModif());
				rs = st.executeQuery();
				while(rs.next()){
					lesFH.add(new LigneFraisHorsForfait(rs.getInt(1),rs.getString(2),rs.getString(1),rs.getString(1),rs.getDate(1),rs.getFloat(1)));
				}
				rs.close();
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesFH;
	}
	
	/***
	 * fonction qui retourne les info grace a un index
	 * @param index
	 * @return ArrayList<LigneFraisForfait>
	 */
	public static ArrayList<LigneFraisForfait> getLesInfos(int index){
		ArrayList<LigneFraisForfait> lesLF = new ArrayList<LigneFraisForfait>();
		ArrayList<FicheFrais> lesF = Modele.getFicheFrais();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM lignefraisforfait WHERE idVisiteur=? AND mois=?;");
			st.setString(1, lesF.get(index).getIdVisiteur());
			st.setInt(2, lesF.get(index).getMois());
			rs = st.executeQuery();
			while(rs.next()){
				lesLF.add(new LigneFraisForfait(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesLF;
	}
	
	/***
	 * fonction qui retourne les info grace a une fiche de frais
	 * @param index
	 * @return ArrayList<LigneFraisForfait>
	 */
	public static ArrayList<LigneFraisForfait> getLesInfos(FicheFrais unf){
		ArrayList<LigneFraisForfait> lesLF = new ArrayList<LigneFraisForfait>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM lignefraisforfait WHERE idVisiteur=? AND mois=?;");
			st.setString(1, unf.getIdVisiteur());
			st.setInt(2, unf.getMois());
			rs = st.executeQuery();
			while(rs.next()){
				lesLF.add(new LigneFraisForfait(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesLF;
	}
	/**
	 * Fonction qui retourne une liste deslignefraisforfait dont l'etat est VA enregistrer dans la bdd. 	
	 * @return lesfraisF de type ArrayList<LigneFraisForfait> 	
	 */ 	
	public static ArrayList<FicheFrais> getFicheFraisValide(){ 		
		ArrayList<FicheFrais> lesFfrais = new ArrayList<FicheFrais>(); 		
		Modele.connexion(); 		
		try { 			
			st = connexion.prepareStatement("SELECT *  FROM fichefrais WHERE idEtat='VA' ORDER BY dateModif DESC;"); 			
			rs = st.executeQuery(); 			
			while(rs.next()){ 				
				lesFfrais.add(new FicheFrais(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6))); 			
			} 			
			rs.close(); 			
			st.close(); 					
			} catch (SQLException e) { 			
				e.printStackTrace(); 		
			} 		
		Modele.deconnexion();
		return lesFfrais; 	
	} 	 	 	
	/** 	 
	 * Fonction qui retourne le nombre de fichefraisValidé selectioner 	 
	 * @return 	 
	 */ 	
	public static int getNbFicheFraisValide(){ 		
		int nb = 0; 		
		Modele.connexion(); 		
		try { 			
			st = connexion.prepareStatement("SELECT count(*) FROM fichefrais WHERE idEtat='VA';"); 			
			rs = st.executeQuery(); 			
			rs.next(); 			
			nb=rs.getInt(1); 			
			rs.close(); 			
			st.close(); 					
			} catch (SQLException e) { 				
				e.printStackTrace(); 		
				} 	
		Modele.deconnexion();
		return nb;
	}
	public static boolean plusQ(){
		boolean rep = false;
		return rep;
	}
	
	/***
	 * Fonction qui permet de valider une fiche
	 * @param unf
	 * @return true/false
	 */
	public static boolean valider(FicheFrais unf){
		boolean rep = false; 		
		Modele.connexion(); 		
		try { 			
			st = connexion.prepareStatement("UPDATE fichefrais SET idEtat='VA' WHERE idVisiteur=? AND mois=? AND idEtat='CL';");
			st.setString(1,unf.getIdVisiteur());
			st.setInt(2,unf.getMois());
			st.executeUpdate();
			st.close();
			rep = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	
	/***
	 * Fonction qui permet de mettre en remboursement une fiche
	 * @param unf de type FicheFrais, montant de type float
	 * @return true/false
	 */
	public static boolean miseEnRemboursement(FicheFrais unf,float montant){
		boolean rep = false; 		
		Modele.connexion(); 		
		try { 			
			st = connexion.prepareStatement("UPDATE fichefrais SET idEtat='RB' WHERE idVisiteur=? AND mois=? AND idEtat='VA';");
			st.setString(1,unf.getIdVisiteur());
			st.setInt(2,unf.getMois());
			st.executeUpdate();
			st.close();
			st = connexion.prepareStatement("UPDATE fichefrais SET montantValide=? WHERE idVisiteur=? AND mois=? AND idEtat='VA';");
			st.setFloat(1,montant);
			st.setString(2,unf.getIdVisiteur());
			st.setInt(3,unf.getMois());
			st.executeUpdate();
			st.close();
			rep = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	
}