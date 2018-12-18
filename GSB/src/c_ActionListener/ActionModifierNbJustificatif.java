package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.V_FicheValiderConsulter;
import vue.V_Menu;
import class_bdd.FicheFrais;

public class ActionModifierNbJustificatif implements ActionListener{

	private JFrame fenetre;
	private int just;
	private int index;
	
	public ActionModifierNbJustificatif(JFrame fenetre, FicheFrais j, int nbJ, int index){
		this.fenetre = fenetre;
		this.just = nbJ;
		this.index = index;
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane jop1 = new JOptionPane();
		JOptionPane jop2 = new JOptionPane();
		String nb = jop1.showInputDialog(null, "Indiquer la nouvelle valeur du nombre de justificatif :",
				"Modification :", JOptionPane.QUESTION_MESSAGE);
		if(!nb.equals(null)){
			this.just = Integer.parseInt(nb);
			jop2.showMessageDialog(null, "Votre modififcation est un succès", "Modification :",
					JOptionPane.INFORMATION_MESSAGE);
			this.fenetre.getContentPane().removeAll();
			this.fenetre.getContentPane().add(new V_FicheValiderConsulter(this.fenetre,this.index,this.just));
			this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
			this.fenetre.revalidate();
		}
	}

}
