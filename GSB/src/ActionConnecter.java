import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ActionConnecter implements ActionListener{
	private String id;
	private String mdp;
	private V_Connexion vue;
	
	public ActionConnecter(JTextField untxt, JTextField unmdp, V_Connexion v_Connexion){
		this.id = untxt.getText();
		this.mdp=unmdp.getText();
		this.vue = v_Connexion;
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Modele.connexionUtilisateur(this.id, this.mdp)){
			this.vue.getRootPane().removeAll();
			this.vue.getRootPane().add(new V_Index());
			this.vue.revalidate();
		}else{
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Le mot de passe ou le login est faux !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
