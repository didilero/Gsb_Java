package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.V_FicheFraisAttente;
import vue.V_Menu;

public class ActionConsulterFicheFrais implements ActionListener {
	private JFrame fenetre;
	
	public ActionConsulterFicheFrais(JFrame unef){
		this.fenetre = unef;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(new V_FicheFraisAttente(this.fenetre));
		this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
		this.fenetre.revalidate();
	}
}
