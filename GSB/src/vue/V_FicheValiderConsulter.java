package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import class_bdd.FicheFrais;
import class_bdd.LigneFraisForfait;
import modele.Modele;
import c_ActionListener.ActionMiseEnRemboursement;

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
	
	public V_FicheValiderConsulter(JFrame fenetre, int index){
		FicheFrais j = Modele.getFicheFraisValide().get(index);
		this.lesF = Modele.getLesInfos(j); 
		float montantT = 0;
		for(int i =0; i<this.lesF.size();i++){
			this.data[0][i]=this.lesF.get(i).getQuantite();
			montantT = montantT + (this.lesF.get(i).getQuantite() * this.tabV[i]);
		}
		this.data[1][0]= "Montant Total";
		this.data[1][1]= montantT;
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau.setPreferredScrollableViewportSize(new Dimension(500, 100));
		this.scrollPane = new JScrollPane(this.tableau);
		this.add(this.scrollPane);
		
		this.setBackground(new Color(243,169,47));
		this.btnR = new JButton("Mise en remboursement");
		this.btnR.addActionListener(new ActionMiseEnRemboursement(fenetre,index,montantT));
		this.add(this.btnR);
	}

}
