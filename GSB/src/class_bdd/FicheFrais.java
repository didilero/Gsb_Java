package class_bdd;

import java.sql.Date;

public class FicheFrais {
	private String idVisiteur;
	private int mois;
	private int nbJustificatifs;
	private int montantValide;
	private Date dateModif;
	private String idEtat;
	
	public FicheFrais(String idVisiteur, int mois, int nbJustificatifs,
			int montantValide, Date dateModif, String idEtat) {
		this.idVisiteur = idVisiteur;
		this.mois = mois;
		this.nbJustificatifs = nbJustificatifs;
		this.montantValide = montantValide;
		this.dateModif = dateModif;
		this.idEtat = idEtat;
	}
	
	public String getIdVisiteur() {
		return idVisiteur;
	}
	public int getMois() {
		return mois;
	}
	public int getNbJustificatifs() {
		return nbJustificatifs;
	}
	public int getMontantValide() {
		return montantValide;
	}
	public Date getDateModif() {
		return dateModif;
	}
	public String getIdEtat() {
		return idEtat;
	}
}
