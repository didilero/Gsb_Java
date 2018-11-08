import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;





import javax.swing.*;


public class V_Index extends JFrame{
	private JPanel monPanel;
	
	public V_Index(){
		this.setTitle("Connexion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.getContentPane().removeAll();
		this.monPanel = new V_Connexion();
		
		
		this.getContentPane().add(monPanel);
		this.monPanel.setOpaque(false);
		this.setVisible(true);
		
	}

	
}
