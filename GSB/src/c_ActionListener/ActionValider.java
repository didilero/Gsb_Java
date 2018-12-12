package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import class_bdd.FicheFrais;
import modele.Modele;

public class ActionValider implements ActionListener{
	private JFrame fenetre;
	private int index;

	public ActionValider(JFrame vue, int index){
		this.fenetre = vue;
		this.index = index;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ArrayList<FicheFrais> lesI = Modele.getFicheFrais();
		FicheFrais f= lesI.get(this.index);
		Modele.valider(f);
		this.fenetre.revalidate();
	}

}
