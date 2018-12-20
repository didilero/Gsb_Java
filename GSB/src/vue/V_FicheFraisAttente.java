package vue;

import modele.*;
import c_ActionListener.ActionConsulterValider;
import class_bdd.FicheFrais;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;


public class V_FicheFraisAttente extends JPanel implements FocusListener{
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbFicheFrais()][6];
	private String[] title = { "idVisiteur", "mois" ,"nbJustificatifs","montantValide","dateModif","idEtat" };
	private JButton btn;
	private int index;
	
	// A faire ajouter un deuxieme tableau avec les fiche frais hors forfait a rajouter
	public V_FicheFraisAttente(JFrame vue){
		ArrayList<FicheFrais> lesf = Modele.getFicheFrais();
		
		//On remplit le tableau des informations nécessaire a son affichage
		for(int i =0; i<lesf.size();i++){
			this.data[i][0]=lesf.get(i).getIdVisiteur();
			this.data[i][1]=lesf.get(i).getMois();
			this.data[i][2]=lesf.get(i).getNbJustificatifs();
			this.data[i][3]=lesf.get(i).getMontantValide();
			this.data[i][4]=lesf.get(i).getDateModif();
			this.data[i][5]=lesf.get(i).getIdEtat();
		}
		this.tableau = new JTable(this.data, this.title);
		//on met en ecoute le tableau pour une future selection
		this.tableau.addFocusListener(this);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 300));
		//on ajoute le tableau dans le scrollpane
		this.scrollPane = new JScrollPane(this.tableau);
		this.btn = new JButton("Voir fiche");
		this.btn.addActionListener(new ActionConsulterValider(vue,index));
		this.setBackground(new Color(243,169,47));
		this.add(this.scrollPane);
		//Ajout d'une zone de texte et d'un bouton
		this.add(new JLabel("Selectionner une fiche pour la validé"));
		this.add(this.btn);
	}
	public void focusGained(FocusEvent arg0) {
		// Permet de recupere la ligne du tableau selectionné
		this.index = this.tableau.getSelectedRow();
	}
	public void focusLost(FocusEvent arg0) {
	}
}
