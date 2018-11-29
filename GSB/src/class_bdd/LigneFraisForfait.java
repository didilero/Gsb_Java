package class_bdd;

import java.sql.Date;

public class LigneFraisForfait {
	

	private String idVisiteur;
	private Date mois;
	private String idFraisForfait;
	private int quantite;
	
	public LigneFraisForfait(String idVisiteur, Date date, String string,int quantite) {
		this.idVisiteur = idVisiteur;
		this.mois = date;
		this.idFraisForfait = string;
		this.quantite = quantite;
	}
	//Getteurs
	public String getIdVisiteur() {
		return idVisiteur;
	}
	public Date getMois() {
		return mois;
	}
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public int getQuantite() {
		return quantite;
	}
}
