
package c_ActionListener; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.*;


public class ActionConsulterFicheFraisValide  implements ActionListener {
	private JFrame fenetre;
	
	public ActionConsulterFicheFraisValide (JFrame unef){
		this.fenetre = unef;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(new V_FicheFraisDejaValide(this.fenetre));
		this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
		this.fenetre.revalidate();
		
	}

}
