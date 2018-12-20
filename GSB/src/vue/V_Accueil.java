package vue;
import java.awt.*;

import javax.swing.*;


public class V_Accueil extends JPanel {
	/**
	 * 
	 */
	private JLabel image;
	private static final long serialVersionUID = 1L;
	private JLabel txt;

	public V_Accueil(JFrame vue){
		//Affichage de la page d'accueil
		String message = "<html>"
				+ "<body>"
				+ "<h1>Bienvenue</h1>"
				+ "</body>"
				+ "</html>";
		//Affichage du message
		this.txt= new JLabel(message,JLabel.CENTER);
		this.setLayout(new GridLayout(3,1));
		//Ajout d'une image
		ImageIcon icone=new ImageIcon(Object.class.getResource("/Image/logo.jpg"));
		this.image=new JLabel(icone);
		
		//Changement de la couleur du background
		this.setBackground(new Color(243,169,47));
		this.add(this.txt);
		this.add(this.image);
		
	}
	
}