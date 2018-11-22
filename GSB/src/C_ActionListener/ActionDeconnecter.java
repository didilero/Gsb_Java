package C_ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionDeconnecter implements ActionListener {
	private JFrame vue;
	
	public ActionDeconnecter(JFrame unef){
		this.vue=unef;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vue.dispose();
	}

}
