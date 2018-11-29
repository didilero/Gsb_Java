package vue;

import modele.*;
import class_bdd.FicheFrais;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;


public class V_FicheFraisAttente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbFicheFrais()][6];
	private String[] title = { "idVisiteur", "mois" ,"nbJustificatifs","montantValide","dateModif","idEtat" };
	
	// A faire ajouter un deuxieme tableau avec les fiche frais hors forfait a rajouter
	public V_FicheFraisAttente(JFrame vue){
		ArrayList<FicheFrais> lesf = Modele.getFicheFrais();
		for(int i =0; i<lesf.size();i++){
			this.data[i][0]=lesf.get(i).getIdVisiteur();
			this.data[i][1]=lesf.get(i).getMois();
			this.data[i][2]=lesf.get(i).getNbJustificatifs();
			this.data[i][3]=lesf.get(i).getMontantValide();
			this.data[i][4]=lesf.get(i).getDateModif();
			this.data[i][5]=lesf.get(i).getIdEtat();
		}
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau.setPreferredScrollableViewportSize(new Dimension(300, 300));
		this.scrollPane = new JScrollPane(this.tableau);
		
		this.setBackground(new Color(243,169,47));
		this.add(this.scrollPane);
	}
}
