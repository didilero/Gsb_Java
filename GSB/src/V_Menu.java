import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class V_Menu extends JMenuBar implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuQuitter;
	private JMenuItem btnQuitter;
	//ajout
	
	public V_Menu(){	
		
		//menu
		this.menuQuitter = new JMenu("Quitter");
		this.btnQuitter = new JMenuItem("Quitter");
		this.btnQuitter.addActionListener(new ActionQuitter());
		this.menuQuitter.add(this.btnQuitter);
		
		this.add(menuQuitter);
		//this.btnQuitter.addActionListener(new ActionQuitter());
	}
	
	class ActionQuitter implements ActionListener{
		public void actionPerformed(ActionEvent e) {		
			System.exit(0);
		}
	}







	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
