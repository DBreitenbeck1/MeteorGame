import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	MainFrame(){		
		
		GamePane gPane = new GamePane();
		
		gPane.setLocation(0,0);
		gPane.setSize(this.getSize());
		this.add(gPane);
		this.setVisible(true);  
		this.setTitle("Meteor"); 
		this.setResizable(false);
		this.setSize(700, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth()/2 - this.getSize().getWidth()/2), (int)(screenSize.getHeight()/2-this.getSize().getHeight()/2));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		this.setLayout(null);
//		this.pack();

		
	}
	
}
