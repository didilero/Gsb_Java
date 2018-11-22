
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class V_Connexion extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ajout
	private JTextField jtflog;
	private JTextField jtfMdp;
	private JLabel lblMessage;
	private JLabel lblMessage1;
	private JButton btnValider;
	
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
		this.btnValider.addActionListener(new ActionConnecter(this.jtflog,this.jtfMdp,this));
		
		this.add(lblMessage);	
		this.add(jtflog);	
		this.add(lblMessage1);
		this.add(jtfMdp);
		this.add(btnValider);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}