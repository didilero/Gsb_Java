package vue;

import modele.*;
import c_ActionListener.ActionConsulterValider;
import class_bdd.FicheFrais;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;


public class V_FicheFraisAttente extends JPanel implements ActionListener,FocusListener{
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbFicheFrais()][6];
	private String[] title = { "idVisiteur", "mois" ,"nbJustificatifs","montantValide","dateModif","idEtat" };
	private JButton btn;
	private int index;
	
	// A faire ajouter un deuxieme tableau avec les fiche frais hors forfait a rajouter
	@SuppressWarnings("static-access")
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
		this.tableau.addFocusListener(this);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 300));
		this.scrollPane = new JScrollPane(this.tableau);
		this.btn = new JButton("Voir fiche");
		this.btn.addActionListener(new ActionConsulterValider(vue,index));
		this.setBackground(new Color(243,169,47));
		this.add(this.scrollPane);
		this.add(new JLabel("Selectionner une fiche pour la validé"));
		this.add(this.btn);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		this.index = this.tableau.getSelectedRow();
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}
}
