package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import vue.Pdf;
import class_bdd.FicheFrais;
import class_bdd.LigneFraisForfait;

public class ActionPdf  implements ActionListener{

	private FicheFrais fiche;
	private ArrayList<LigneFraisForfait> lignefrais;

	public ActionPdf(FicheFrais j, ArrayList<LigneFraisForfait> lesF) {
		this.fiche = j;
		this.lignefrais = lesF;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Pdf(this.fiche,this.lignefrais);
		JOptionPane.showMessageDialog(null, "Vottre PDF a bien été enregisté préalablement dans le dossier P:/gitGsb/GSB/pdf", "Création PDF :",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
