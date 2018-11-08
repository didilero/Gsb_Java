import java.awt.*;
import javax.swing.*;


public class V_Connexion extends JPanel{
	
	//ajout
	private JTextField jtflog;
	private JTextField jtfMdp;
	private JLabel lblMessage;
	private JLabel lblMessage1;
	

	private JButton btnValider;
	private JButton btnQuitter;
	
	public V_Connexion(){
		this.lblMessage = new JLabel ();		
		this.lblMessage.setText("Entrer le login: ");
		
		this.lblMessage1 = new JLabel ();		
		this.lblMessage1.setText("Entrer le mdp: ");
		
		//zone de texte
		this.jtflog = new JTextField(); 
		Font police1 = new Font("Arial", Font.BOLD, 14);
		this.jtflog.setFont(police1);
		this.jtflog.setPreferredSize(new Dimension(100, 30));
		
		this.jtfMdp = new JTextField(); 
		this.jtfMdp.setFont(police1);
		this.jtfMdp.setPreferredSize(new Dimension(100, 30));
		
		this.btnValider = new JButton("Valider");
		this.btnQuitter = new JButton("Quitter");
		
		this.add(lblMessage);	
		this.add(jtflog);	
		this.add(lblMessage1);
		this.add(jtfMdp);
		this.add(btnValider);
		this.add(btnQuitter);
		
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
	}*/

	
}
