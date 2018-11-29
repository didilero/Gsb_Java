package class_bdd;

import java.sql.Date;

public class LigneFraisHorsForfait {
	private int id;
	private String idVisiteur;
	private String mois;
	private String libelle;
	private Date date;
	private float montant;
	
	public LigneFraisHorsForfait(int id, String string, String mois, String libelle, Date date2, float f) {
		this.id = id;
		this.idVisiteur = string;
		this.mois = mois;
		this.libelle = libelle;
		this.date = date2;
		this.montant = f;
	}
	//getteurs
	public int getId() {
		return id;
	}
	public String getIdVisiteur() {
		return idVisiteur;
	}
	public String getMois() {
		return mois;
	}
	public String getLibelle() {
		return libelle;
	}
	public Date getDate() {
		return date;
	}
	public float getMontant() {
		return montant;
	}
}
