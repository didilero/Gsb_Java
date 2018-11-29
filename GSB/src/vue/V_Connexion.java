package vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import c_ActionListener.*;



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
	private JLabel image;
	private JPanel labelSaisie;
	private JPanel panelImage;
	
	public V_Connexion(V_Index v_Index){
		v_Index.setLayout(new BorderLayout());
		// panel de saisie
		this.labelSaisie = new JPanel();
		this.labelSaisie.setLayout(new GridLayout(5,1));
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
		
		// Bouton
		this.btnValider = new JButton("Valider");
		this.btnValider.addActionListener(new ActionConnecter(this.jtflog,this.jtfMdp,v_Index));
		
		// Ajout des elements dans un jpanel
		this.labelSaisie.add(this.lblMessage);
		this.labelSaisie.add(this.jtflog);
		this.labelSaisie.add(this.lblMessage1);
		this.labelSaisie.add(this.jtfMdp);
		this.labelSaisie.add(this.btnValider);
		
		this.panelImage = new JPanel();
		ImageIcon icone=new ImageIcon(Object.class.getResource("/Image/logo.jpg"));
		this.image=new JLabel(icone);
		this.panelImage.add(this.image);
		
		this.setBackground(new Color(243,169,47));
		this.add(this.panelImage);
		this.add(this.labelSaisie,FlowLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}