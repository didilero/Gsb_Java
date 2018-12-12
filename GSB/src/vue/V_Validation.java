package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import modele.Modele;
import c_ActionListener.ActionMoinsQ;
import c_ActionListener.ActionPlusQ;
import c_ActionListener.ActionValider;
import class_bdd.LigneFraisForfait;

public class V_Validation extends JPanel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LigneFraisForfait> lesF;
	private JButton btnV;
	
	public V_Validation(JFrame vue, int index){
		//this.setLayout(new GridLayout(5,2));
		this.lesF = Modele.getLesInfos(index);
		this.add(new JLabel("<html><p>Voici vos informations : </p></html>"));
		for(int i =0; i<this.lesF.size();i++){
			String idF = this.lesF.get(i).getIdFraisForfait();
			String mois = this.lesF.get(i).getMois();
			int q = this.lesF.get(i).getQuantite();
			this.add(new JLabel("<html><p style=\"border:solid 2px #8B4513;font-syze:18px;padding:3px; border-raduis:15px;\">"+"idEtat : "
					+idF+"<br/>"+"Date : "+mois+"<br/>"+"quantite : "+q+"</p></html>",JLabel.CENTER));
			JButton btnPlus = new JButton("+");
			btnPlus.addActionListener(new ActionPlusQ());
			JButton btnMoins = new JButton("-");
			btnMoins.addActionListener(new ActionMoinsQ());
			this.add(btnPlus);
			this.add(btnMoins);
		}
		this.setBackground(new Color(243,169,47));
		this.btnV = new JButton("Valider");
		this.btnV.addActionListener(new ActionValider(vue,index));
		this.add(this.btnV);
	}
}
