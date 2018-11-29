package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import c_ActionListener.*;

public class V_Menu extends JMenuBar implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuQuitter;
	private JMenu menuFicheFrais;
	private JMenuItem btnQuitter;
	private JMenuItem btnVoirFiche;
	private JMenuItem btnValideFiche;
	//ajout
	public V_Menu(JFrame vue){	
		
		//menu deconnexion
		this.menuQuitter = new JMenu("Déconnexion");
		this.btnQuitter = new JMenuItem("Quitter");
		this.btnQuitter.addActionListener(new ActionDeconnecter(vue));
		this.menuQuitter.add(this.btnQuitter);
		
		this.menuFicheFrais = new JMenu("Fiches de frais");
		this.btnVoirFiche = new JMenuItem("Fiches de frais à validées");
		this.btnVoirFiche.addActionListener(new ActionConsulterFicheFrais(vue));
		this.btnValideFiche = new JMenuItem("Fiches de frais validées");
		this.menuFicheFrais.add(this.btnVoirFiche);
		this.menuFicheFrais.add(this.btnValideFiche);
		
		this.add(menuQuitter);
		this.add(menuFicheFrais);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
