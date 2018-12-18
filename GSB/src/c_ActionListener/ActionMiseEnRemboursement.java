package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import class_bdd.FicheFrais;
import modele.Modele;
import vue.V_FicheFraisDejaValide;
import vue.V_Menu;

public class ActionMiseEnRemboursement implements ActionListener{
	
	private int index;
	private JFrame fenetre;
	private boolean rep;
	private float montant;
	
	public ActionMiseEnRemboursement(JFrame vue, int index, float montantT){
		this.fenetre= vue;
		this.index = index;
		this.montant = montantT;
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(new V_FicheFraisDejaValide(this.fenetre));
		this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
		FicheFrais j = Modele.getFicheFraisValide().get(index);
		if(Modele.miseEnRemboursement(j, this.montant)){
			JOptionPane jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "La fiche a bien été mise en remboursement.","Infos ",  JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "La mise en remboursement n'a pas aboutie.","Message d'erreur", JOptionPane.ERROR_MESSAGE);
		}
		this.fenetre.revalidate();
	}
}
