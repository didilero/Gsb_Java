package class_bdd;

public class LigneFraisForfait {
	

	private String idVisiteur;
	private String mois;
	private String idFraisForfait;
	private int quantite;
	
	public LigneFraisForfait(String idVisiteur, String string2, String string,int quantite) {
		this.idVisiteur = idVisiteur;
		this.mois = string2;
		this.idFraisForfait = string;
		this.quantite = quantite;
	}
	//Getteurs
	public String getIdVisiteur() {
		return idVisiteur;
	}
	public String getMois() {
		return mois;
	}
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public int getQuantite() {
		return quantite;
	}
}
