package c_ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import vue.*;
import modele.*;


public class ActionConnecter implements ActionListener{
	private String id;
	private String mdp;
	private JFrame fenetre;
	
	public ActionConnecter(JTextField untxt, JTextField unmdp, JFrame v_Index){
		this.id = untxt.getText();
		this.mdp=unmdp.getText();
		this.fenetre = v_Index;
	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		if(Modele.connexionUtilisateur(this.id, this.mdp)){
			this.fenetre.getContentPane().removeAll();
			this.fenetre.getContentPane().add(new V_Accueil(this.fenetre));
			this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
			this.fenetre.revalidate();
		}else{
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Le mot de passe ou le login est faux !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
