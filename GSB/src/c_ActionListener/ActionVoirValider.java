package c_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.V_FicheValiderConsulter;
import vue.V_Menu;

public class ActionVoirValider implements ActionListener{
	private int index;
	private JFrame fenetre;
	
	public ActionVoirValider(JFrame vue, int index){
		this.fenetre= vue;
		this.index = index;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.fenetre.getContentPane().removeAll();
		this.fenetre.getContentPane().add(new V_FicheValiderConsulter(this.fenetre,this.index,0));
		this.fenetre.setJMenuBar(new V_Menu(this.fenetre));
		this.fenetre.revalidate();
	}

}
