import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePane extends JPanel implements ActionListener, KeyListener  {
	Timer gameTimer;
	ArrayList<Block> blocks = new ArrayList<>();
	Block block;
	
	GamePane(){
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask(){

			@Override
			public void run() {
				repaint();
				
			}
			
		}, 0, 17);
		/*these numbers refer to the frame rate: 0 is how long before the timer starts a
		17 how many milliseconds between frames. 17 ms between frames is roughly 60 frames 
		second*/

		makeBlocks();
		
		
		gameTimer.schedule(new TimerTask(){

			@Override
			public void run() {
				repaint();
				rise();	
			}
			
		}, 0, 3000);
		
		
		}
		

public void makeBlocks() {
		
		for (int i =0; i<700; i+=100) {
			blocks.add(new Block(i, 650, 100, 50, 1));
			}
		
	}
	
	public void rise() throws ConcurrentModificationException {
		for(Block block: blocks) {
			block.y-=50;
		}
		int size = blocks.size()-1;	

		for (int i = size; i>(size-7); i--){
			int rand = (int)(Math.random()*3)+1;
			if(rand == 3 || rand == 2) {
				rand = (int)(Math.random()*rand)+1;
			}
			System.out.println(rand);
			if(blocks.get(i).active) { 	
				blocks.add(new Block(blocks.get(i).x, blocks.get(i).y+50, 100, 50, rand));
				
			}
		}
		
		
		
	}
	
		

	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D gtd =(Graphics2D) g;
		
//		player.draw(gtd);
		
		for (Block block: blocks) {
			block.draw(gtd);
			
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
