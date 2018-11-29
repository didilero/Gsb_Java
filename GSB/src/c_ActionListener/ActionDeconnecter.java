package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionDeconnecter implements ActionListener {
	private JFrame fenetre;
	
	public ActionDeconnecter(JFrame unef){
		this.fenetre=unef;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.fenetre.dispose();
	}

}
