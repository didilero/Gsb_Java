package vue;
import javax.swing.*;


public class V_Index extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel monPanel;
	
	public V_Index(){
		this.setTitle("GSB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.getContentPane().removeAll();
		this.monPanel = new V_Connexion(this);
		//icon de l'appli 		
		setIconImage(new ImageIcon(this.getClass().getResource("/Image/logoGSB.png")).getImage());
		
		this.getContentPane().add(monPanel);
		this.monPanel.setOpaque(false);
		this.setVisible(true);
	}
}