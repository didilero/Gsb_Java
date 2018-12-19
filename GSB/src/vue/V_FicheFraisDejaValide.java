
package vue;

import modele.*;
import c_ActionListener.ActionVoirValider;
import class_bdd.FicheFrais;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;


public class V_FicheFraisDejaValide extends JPanel implements FocusListener{
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbFicheFraisValide()][6];
	private String[] title = { "idVisiteur", "mois" ,"nbJustificatifs","montantValide","dateModif","idEtat" };
	private int index;
	private JButton btnVoir;
	
	// A faire ajouter un deuxieme tableau avec les fiche frais hors forfait a rajouter
	public V_FicheFraisDejaValide(JFrame vue){
		ArrayList<FicheFrais> lesf = Modele.getFicheFraisValide();

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
		this.tableau.addFocusListener(this);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 300));
		this.scrollPane = new JScrollPane(this.tableau);
		this.setBackground(new Color(243,169,47));
		this.add( new JLabel("<html>"+"<h2 style=\"font-family:Comic Sans MS\">"+" Liste des visiteurs dont les fiches sont valid�es:"+"</h2></html>",JLabel.CENTER));
		this.add(this.scrollPane);
		this.btnVoir = new JButton("Voir fiche");
		this.btnVoir.addActionListener(new ActionVoirValider(vue,this.index));
		this.add(this.btnVoir);
	}
	
	//M�thode pour indiquer l'index du tableau selectionner
	public void focusGained(FocusEvent arg0) {
		this.index = this.tableau.getSelectedRow();
	}
	//Pas r�ecrite cra elle ne nous ai pas pratique
	public void focusLost(FocusEvent arg0) {
		
	}
} 