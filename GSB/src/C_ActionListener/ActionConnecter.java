package C_ActionListener;
import Modele.*;
import Vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ActionConnecter implements ActionListener{
	private String id;
	private String mdp;
	private JFrame vue;
	
	public ActionConnecter(JTextField untxt, JTextField unmdp, JFrame v_Index){
		this.id = untxt.getText();
		this.mdp=unmdp.getText();
		this.vue = v_Index;
	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		if(Modele.connexionUtilisateur(this.id, this.mdp)){
			this.vue.getContentPane().removeAll();
			this.vue.getContentPane().add(new V_Accueil(this.vue));
			this.vue.setJMenuBar(new V_Menu(this.vue));
			this.vue.revalidate();
		}else{
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Le mot de passe ou le login est faux !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
