package Vue;
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
		this.txt= new JLabel("Bonjour");
		this.setLayout(new GridLayout(3,1));
		ImageIcon icone=new ImageIcon(Object.class.getResource("/Image/logo.jpg"));
		this.image=new JLabel(icone);
		
		this.setBackground(new Color(243,169,47));
		this.add(this.image);
		this.add(this.txt);
	}
	
}