import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;




public class V_Accueil extends JPanel {
	
	private JMenuBar menu;
	
	private JMenu menuQuitter;
	private JMenuItem btnQuitter;
	//ajout
	
	private JLabel lblMessage;

	
	public V_Accueil(){	
		
		
		lblMessage = new JLabel ();
		if(Modele.connexion()){			
			lblMessage.setText("Bienvenue");
			
		}else{
			lblMessage.setText("erreur!!");
		}
		;
		this.add(lblMessage);
		
		//this.btnValider.addActionListener(new ActionConnexion());
		//this.btnQuitter.addActionListener(new ActionQuitter());
		
		
		
	}
	


	
	/*class ActionConnexion implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		 JLabel lblMessageErreur;
			if(Modele.testconnexion( jtflog.getText(), jtfMdp.getText())){
				
				
				
			}
			else{
				getContentPane().revalidate();
				lblMessageErreur = new JLabel ("Erreur de mot de passe ou d'identifiant");
				monPanel.add(lblMessageErreur);
				
				
			}
			
			
		}

	}
	
	
	
	class ActionQuitter implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			dispose();
		}
	}
*/
	
}