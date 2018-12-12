package c_ActionListener; 

import java.awt.event.*;

import javax.swing.JFrame;
import vue.V_Menu;
import vue.V_Validation;

public class ActionConsulterValider implements ActionListener {
	private JFrame fenetre;
	private int index;
	public ActionConsulterValider(JFrame vue, int i){
		this.fenetre=vue;
		this.index = i;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(new V_Validation(this.fenetre,this.index));
		this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
		this.fenetre.revalidate();
	}
}
