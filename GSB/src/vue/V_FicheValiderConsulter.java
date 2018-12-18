package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import class_bdd.FicheFrais;
import class_bdd.LigneFraisForfait;
import modele.Modele;
import c_ActionListener.ActionMiseEnRemboursement;
import c_ActionListener.ActionModifierNbJustificatif;

public class V_FicheValiderConsulter extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[2][5];
	private String[] title = { "Forfait etape", "Frais Kilometrique" ,"Nuitée Hôtel","Repas Restaurant"};
	private float[] tabV={(float) 110.00,(float) 0.62,(float) 80.00,(float) 25.00};
	private ArrayList<LigneFraisForfait> lesF;
	private JButton btnR;
	private JButton btnM;
	private int nbJ;
	
	public V_FicheValiderConsulter(JFrame fenetre, int index,int nb){
		//Récupératon de la fichedefraisValide a l'index donné
		FicheFrais j = Modele.getFicheFraisValide().get(index);
		//Récupération des infos de cette fiche
		this.lesF = Modele.getLesInfos(j); 
		//Initialisation de la variable du montant total ainsi que du nb de justificatif
		float montantT = 0;
		this.nbJ = nb;//Forcement a 0 car le visiteur ne peut pa sdecider de combien il y a de justificatif seul le comptable peut modifier cette valeur
		//Mise en orange du background
		this.setBackground(new Color(243,169,47));
		
		//Insertion des informations de la fiche dans un tableau
		for(int i =0; i<this.lesF.size();i++){
			this.data[0][i]=this.lesF.get(i).getQuantite();
			montantT = montantT + (this.lesF.get(i).getQuantite() * this.tabV[i]);
		}
		//Ajout dans ce tableau du montant total calcule dans la boucle précédente
		this.data[1][0]= "Montant Total";
		this.data[1][1]= montantT;
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 100));
		this.scrollPane = new JScrollPane(this.tableau);
		// Ajout du scrollpane dans le JLabel
		this.add(this.scrollPane);
		// Saut de ligne
		this.add(new JLabel("<html><br/></html>"));
		
		//création du bouton de mise en remboursement qui renvoie vers l'action listener ActionMiseEnRemboursement
		this.btnR = new JButton("Mise en remboursement");
		this.btnR.addActionListener(new ActionMiseEnRemboursement(fenetre,index,montantT,this.nbJ));
		
		// création de la gestion de la modification du nombre de justificatif qui renvoie vers l'action listener ActionModifierNbJustificatif
		this.add(new JLabel("Nombres justificatifs : "+this.nbJ));
		this.btnM = new JButton("Modifier Nombre Justificatif");
		this.btnM.addActionListener(new ActionModifierNbJustificatif(fenetre,j,this.nbJ,index));
		
		//Pour une question d'esthétique le bouton mise en remboursement est ajouter a la fin
		this.add(this.btnM);
		this.add(new JLabel("<html><br/></html>"));
		this.add(this.btnR);
	}
}

